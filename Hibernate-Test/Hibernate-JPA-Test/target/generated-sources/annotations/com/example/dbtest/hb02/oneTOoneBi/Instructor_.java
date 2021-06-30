package com.example.dbtest.hb02.oneTOoneBi;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Instructor.class)
public abstract class Instructor_ {

	public static volatile SingularAttribute<Instructor, InstructorDetail> instructorDetail;
	public static volatile SingularAttribute<Instructor, String> firstName;
	public static volatile SingularAttribute<Instructor, String> lastName;
	public static volatile SingularAttribute<Instructor, Integer> id;

	public static final String INSTRUCTOR_DETAIL = "instructorDetail";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String ID = "id";

}

