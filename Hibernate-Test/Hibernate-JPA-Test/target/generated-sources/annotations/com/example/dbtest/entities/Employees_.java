package com.example.dbtest.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employees.class)
public abstract class Employees_ {

	public static volatile SingularAttribute<Employees, String> firstName;
	public static volatile SingularAttribute<Employees, String> lastName;
	public static volatile SingularAttribute<Employees, Integer> id;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String ID = "id";

}

