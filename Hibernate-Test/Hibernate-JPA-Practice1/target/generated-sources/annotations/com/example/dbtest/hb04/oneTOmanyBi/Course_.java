package com.example.dbtest.hb04.oneTOmanyBi;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Course.class)
public abstract class Course_ {

	public static volatile ListAttribute<Course, Review> reviews;
	public static volatile SingularAttribute<Course, String> name;
	public static volatile SingularAttribute<Course, Integer> id;

	public static final String REVIEWS = "reviews";
	public static final String NAME = "name";
	public static final String ID = "id";

}

