package com.example.dbtest.review;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class RMSDao {
	
	private static final RMSDao INSTANCE = new RMSDao();

	private final EntityManager em;
	
	private RMSDao() {
		em = EmfBuilder.getInstance().getEntityManager();
	}
	
	public static RMSDao getInstance() {
		return INSTANCE;
	}

	public Object getEntityById(Class<?> cls, int id) {
		return em.find(cls, id);
	}
	
	/**
	 * Fetch all Project from db.
	 * @return
	 */
	public List<Project> fetchAllProject() {
		final TypedQuery<Project> prjQuery = 
				em.createQuery("select prj from Project prj", Project.class);
		
		final List<Project> projects = prjQuery.getResultList();
		return projects;
	}
	
	/**
	 * Fetch ProjectDetail for a specific Mgr.
	 * @param empId
	 * @return
	 */
	public List<ProjectDetail> getProjectDetails(int empId) {
		
		final TypedQuery<Employee> empQuery = em.createQuery("select emp from Employee emp where "
				+ "emp.empUserId = ?1", Employee.class)
		.setParameter(1, empId);
		
		final Employee employee = empQuery.getSingleResult();
		
		System.out.println("Employee Name: " + employee.getEmpUserName());
		
		final TypedQuery<ProjectDetail> prjDetailQuery = 
				em.createQuery("select prjDet from ProjectDetail prjDet where "
						+ "prjDet.employee1 = ?1", ProjectDetail.class)
				.setParameter(1, employee);
		
		final List<ProjectDetail> prjDetails = prjDetailQuery.getResultList();
		
		return prjDetails;
	}
	
	public List<ReviewType> fetchReviewTypesFromPrjId(final int projectId) {
		
//		System.out.println("RMSDao.fetchAllReviewTypes()");
		
		//Project
		final TypedQuery<Project> prjQuery = 
				em.createQuery("select prj from Project prj where "
				+ "prj.projectId = ?1", Project.class)
			.setParameter(1, projectId);
		
		final Project project = prjQuery.getSingleResult();
		
//		System.out.println(project);
		
		//ProjectDetail
		final TypedQuery<ProjectDetail> prjDetailQuery = 
				em.createQuery("select prjDetail from ProjectDetail prjDetail where "
				+ "prjDetail.project = ?1", ProjectDetail.class)
		.setParameter(1, project);
		
		final ProjectDetail prjDetail = prjDetailQuery.getSingleResult();
		
//		System.out.println(prjDetail);
		
		//ReviewType
		final TypedQuery<ReviewType> revTypeQuery = 
				em.createQuery("select revType from ReviewType revType where "
				+ "revType.projectDetail = ?1", ReviewType.class)
				.setParameter(1, prjDetail);
		
		final List<ReviewType> reviewTypes = revTypeQuery.getResultList();
		
		return reviewTypes;
	}
	
	public List<ReviewChecklist> fetchRvwChklistFromRvwTypeId(int rvwTypeId) {
		
		final TypedQuery<ReviewType> rvwTypeQuery = 
				em.createQuery("select rvwType from ReviewType rvwType where "
				+ "rvwType.rvwTypeId = ?1", ReviewType.class)
			.setParameter(1, rvwTypeId);
		
		final ReviewType reviewType = rvwTypeQuery.getSingleResult();
		
		final TypedQuery<ReviewChecklist> rvwChklistQuery = 
				em.createQuery("select rvwChklist from ReviewChecklist rvwChklist where "
				+ "rvwChklist.rvwType = ?1", ReviewChecklist.class)
				.setParameter(1, reviewType);
				
		final List<ReviewChecklist> rvwChkList = rvwChklistQuery.getResultList();
		
		return rvwChkList;
	}
	
	public void addReviewType(ReviewType reviewType) {
		
		final EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(reviewType);
		transaction.commit();
	}
	
	public void addReviewCheckList(final ReviewChecklist rvwChkList) {
		final EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(rvwChkList);
		transaction.commit();
	}
	
	public void removeRvwChkList(final ReviewChecklist rvwChkList) {
		final EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(rvwChkList);
		transaction.commit();
	}
	
	public void updateRvwChkListTable(final ReviewChecklist rvwChkList) {
		
		final EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.createQuery(
				"update ReviewChecklist rvwChklist "+
				"set rvwChklist.reference=:reference, "+
				"rvwChklist.description=:description, "+
				"rvwChklist.tip=:tip, "+
				"rvwChklist.chkListPos=:chkListPos, "+
				"rvwChklist.updatedOn=:updatedOn " + 
				"where rvwChklist.chkListId=:chkListId"
			)
			.setParameter("reference", rvwChkList.getReference())
			.setParameter("description", rvwChkList.getDescription())
			.setParameter("tip", rvwChkList.getTip())
			.setParameter("chkListPos", rvwChkList.getChkListPos())
			.setParameter("updatedOn", rvwChkList.getUpdatedOn())
			.setParameter("chkListId",rvwChkList.getChkListId())
			.executeUpdate();
		
		transaction.commit();
	}
	
}
