package com.example.dbtest.review;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_rms_rvw_type_rrv")
public class ReviewType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RRV_Rvwtypeid", length = 8)
	private int rvwTypeId;
	
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "RRV_Projectid")
	private ProjectDetail projectDetail;
	
	@Column(name = "RRV_Rvwtypename", nullable = false, length = 200)
	private String rvwTypeName;
	
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "RRV_Updatedby")
	private Employee employee;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "RRV_Updatedon")
	private Date updatedOn;

	public ReviewType() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public ReviewType(ProjectDetail projectDetail, String rvwTypeName, 
			Employee employee, Date updatedOn) {
		super();
		this.projectDetail = projectDetail;
		this.rvwTypeName = rvwTypeName;
		this.employee = employee;
		this.updatedOn = updatedOn;
	}

	public int getRvwTypeId() {
		return rvwTypeId;
	}

	public void setRvwTypeId(int rvwTypeId) {
		this.rvwTypeId = rvwTypeId;
	}

	public ProjectDetail getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(ProjectDetail projectDetail) {
		this.projectDetail = projectDetail;
	}

	public String getRvwTypeName() {
		return rvwTypeName;
	}

	public void setRvwTypeName(String rvwTypeName) {
		this.rvwTypeName = rvwTypeName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "ReviewType [rvwTypeId=" + rvwTypeId + ", projectDetail=" + projectDetail + ", rvwTypeName="
				+ rvwTypeName + ", employee=" + employee + ", updatedOn=" + updatedOn + "]";
	}
}
