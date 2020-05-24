package com.anupam.hibernate.demo.entity;

import javax.persistence.Entity;

@Entity
public class Instructor extends User{

	private double salary;

	public Instructor(String firstName, String lastName, double salary) {
		super(firstName, lastName);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Instructor [salary=" + salary + "]";
	}

}
