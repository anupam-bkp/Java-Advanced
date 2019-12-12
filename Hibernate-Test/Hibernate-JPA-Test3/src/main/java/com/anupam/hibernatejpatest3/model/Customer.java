package com.anupam.hibernatejpatest3.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer implements ModelInterface{

	@Id
	@Column(length = ID_COLUMN_SIZE)
	private String id;

	@Column(length = STANDARD_COLUMN_SIZE)
	@NotNull
	@Size(min = 1, max = STANDARD_COLUMN_SIZE)
	@Pattern(regexp = ALPHANUM_PATTERN)
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
    @NotNull
    private Set<Product> products;
	
	public Customer() {

	}
		
	public Customer(String id, String name, Set<Product> products) {
		this.id = id;
		this.name = name;
		this.products = products;
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
}
