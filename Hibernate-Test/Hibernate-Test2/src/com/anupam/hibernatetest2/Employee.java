package com.anupam.hibernatetest2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMP_ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DEPT")
	private String dept;
	
	@Column(name="PHONE")
	private long phone;

	public Employee() {
		
	}
	
	public Employee(String name, String dept, long phone) {
		this.name = name;
		this.dept = dept;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", phone=" + phone + "]";
	}
}
