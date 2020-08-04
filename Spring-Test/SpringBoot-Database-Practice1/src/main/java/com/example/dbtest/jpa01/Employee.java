package com.example.dbtest.jpa01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_fou_employee_emp")
public class Employee {

	@Id
	@Column(name = "EMP_User_id", nullable = false, length = 8) // int(8) NOT NULL,
	private int empUserId;
	
	@Column(name = "EMP_User_name", length = 50)  //varchar(50),
	private String empUserName;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empUserId, String empUserName) {
		super();
		this.empUserId = empUserId;
		this.empUserName = empUserName;
	}

	public int getEmpUserId() {
		return empUserId;
	}

	public void setEmpUserId(int empUserId) {
		this.empUserId = empUserId;
	}

	public String getEmpUserName() {
		return empUserName;
	}

	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}

	@Override
	public String toString() {
		return "Employee [empUserId=" + empUserId + ", empUserName=" + empUserName + "]";
	}
}
