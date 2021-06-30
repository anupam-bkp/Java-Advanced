package com.example.dbtest.hb05.manyTOmany;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Course.class)
public abstract class Course_ {

	public static volatile ListAttribute<Course, Student> students;
	public static volatile SingularAttribute<Course, Integer> id;
	public static volatile SingularAttribute<Course, String> title;

	public static final String STUDENTS = "students";
	public static final String ID = "id";
	public static final String TITLE = "title";

}

