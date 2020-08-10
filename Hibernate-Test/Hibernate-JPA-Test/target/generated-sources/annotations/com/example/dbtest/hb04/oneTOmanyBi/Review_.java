package com.example.dbtest.hb04.oneTOmanyBi;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Review.class)
public abstract class Review_ {

	public static volatile SingularAttribute<Review, Course> course;
	public static volatile SingularAttribute<Review, String> comment;
	public static volatile SingularAttribute<Review, Integer> id;

	public static final String COURSE = "course";
	public static final String COMMENT = "comment";
	public static final String ID = "id";

}

