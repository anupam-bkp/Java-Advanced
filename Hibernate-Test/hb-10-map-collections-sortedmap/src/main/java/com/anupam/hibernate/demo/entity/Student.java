package com.anupam.hibernate.demo.entity;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
//import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.SortComparator;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	@ElementCollection
	@CollectionTable(name="image")
	@MapKeyColumn(name="file_name")		//Map Key Defaults to images_Key
	@Column(name="image_name") //Map Value defaults to images
//	@OrderBy
	@SortComparator(ReverseStringComparator.class)  //If ordering to be based on custom logic
	private Map<String, String> images = new TreeMap<>();
	
	public static class ReverseStringComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}
	}
	
	public Student() {
		// No-arg constructor used by hibernate for data retrieval
	}
	
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, String> getImages() {
		return images;
	}

	public void setImages(Map<String, String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
