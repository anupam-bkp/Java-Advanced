package com.anupam.hibernatetest1;

/**
 * 
 * @author Anupam
 *
 */
public class Employee {

	private int id;
	private String name;
	private String dept;
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
