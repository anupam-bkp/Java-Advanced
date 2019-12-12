package com.anupam.hibernatejpatest3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Product implements ModelInterface{

	@Id
    @Column(length = ID_COLUMN_SIZE)
	private String id;
	
	@Column(length = STANDARD_COLUMN_SIZE)
    @NotNull
    @Size(min = 1, max = STANDARD_COLUMN_SIZE)
    @Pattern(regexp = ALPHANUM_PATTERN)
	private String name;
	
	@Column(length = STANDARD_COLUMN_SIZE)
    @NotNull
    @Size(min = 1, max = STANDARD_COLUMN_SIZE)
    @Pattern(regexp = STRING_PATTERN)
    private String type;

	public Product() {
	 
	}
	
	public Product(String id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
}
