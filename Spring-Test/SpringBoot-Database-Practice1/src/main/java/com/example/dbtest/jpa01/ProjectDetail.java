package com.example.dbtest.jpa01;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_rms_project_details_rpr")
public class ProjectDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "RPR_Projectid", nullable = false)
	private Project project;
	  
	@Column(name = "RPR_Projectname", nullable = false, length =  250)
	private String projectName;
	
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "RPR_Projmgrid")
	private Employee employee1;
		
	@Enumerated(EnumType.STRING)
	@Column(name = "RPR_Projstatus")
	private ProjectStatus projStatus = ProjectStatus.active;
		  
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "RPR_Updatedby")
	private Employee employee2;

	@Column(name = "RPR_Updatedon")
	private Date updatedOn;
	
	public ProjectDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProjectDetail(String projectName) {
		super();
		this.projectName = projectName;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Employee getEmployee1() {
		return employee1;
	}

	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}
	
	public ProjectStatus getProjStatus() {
		return projStatus;
	}

	public void setProjStatus(ProjectStatus projStatus) {
		this.projStatus = projStatus;
	}

	public Employee getEmployee2() {
		return employee2;
	}

	public void setEmployee2(Employee employee2) {
		this.employee2 = employee2;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "ProjectDetail [project=" + project + ", projectName=" + projectName + "]";
	}
}
