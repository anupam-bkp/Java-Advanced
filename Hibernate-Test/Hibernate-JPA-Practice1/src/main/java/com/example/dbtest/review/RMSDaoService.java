package com.example.dbtest.review;

import java.util.List;

public class RMSDaoService {

	private static final RMSDaoService INSTANCE = new RMSDaoService();
	
	private final RMSDao rmsDao;
	
	private RMSDaoService() {
		//For Singleton
		rmsDao = RMSDao.getInstance();
	}
	
	public static RMSDaoService getInstance() {
		return INSTANCE;
	}
	
	public Employee getEmployee(int empId) {
		return (Employee)rmsDao.getEntityById(Employee.class, empId);
	}
	
	public ProjectDetail getProjectDetailById(int id) {
		return (ProjectDetail)rmsDao.getEntityById(ProjectDetail.class, id);
	}
	
	public List<Project> getAllProject() {
		return rmsDao.fetchAllProject();
	}
	
	public List<ProjectDetail> getProjectDetailsByMgrId(int empId){
		return rmsDao.getProjectDetails(empId);
	}
	
	public List<ReviewType> getReviewTypes(int projectId) {
		return rmsDao.fetchReviewTypesFromPrjId(projectId);
	}
	
	public List<ReviewChecklist> getReviewChkLists(int rvwTypeId) {
		return rmsDao.fetchRvwChklistFromRvwTypeId(rvwTypeId);
	}
	
	public void addReviewType(ReviewType reviewType) {
		rmsDao.addReviewType(reviewType);
	}
	
	public void updateReviewChkList(final List<ReviewChecklist> addedList,
			final List<ReviewChecklist> modifiedList, final List<ReviewChecklist> deletedList) {
		
		System.out.println("In RMS DAO Service...");
		
		//Push the newly added ReviewCheckList
		addedList.stream().forEach(rvwChkList -> {
			rmsDao.addReviewCheckList(rvwChkList);
		});
		
		//Push the modified Review Check List
		modifiedList.stream().forEach(rvwChkList -> {
			rmsDao.updateRvwChkListTable(rvwChkList);
		});
		
		//Delete the deleted ReviewCheckList
		deletedList.stream().forEach(rvwChkList -> {
			rmsDao.removeRvwChkList(rvwChkList);
		});
		
	}
	
}
