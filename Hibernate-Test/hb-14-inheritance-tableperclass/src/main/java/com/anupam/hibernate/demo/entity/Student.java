package com.anupam.hibernate.demo.entity;

import javax.persistence.Entity;

@Entity
public class Student extends User{

	private String course;

	public Student(String firstName, String lastName, String course) {
		super(firstName, lastName);
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [course=" + course + "]";
	}
	
}
