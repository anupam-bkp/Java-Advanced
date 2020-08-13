package com.example.dbtest.review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_prj_project_prj")
public class Project {
	
	@Id
	@Column(name = "PRJ_Project_id", nullable = false, length = 8)
	private int projectId;
	 
	@Column(name = "PRJ_Project_name", length = 100)
	private String projectName;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int projectId, String projectName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + "]";
	}
}
