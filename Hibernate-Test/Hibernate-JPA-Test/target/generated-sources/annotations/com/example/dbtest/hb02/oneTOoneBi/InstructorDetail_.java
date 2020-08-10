package com.example.dbtest.hb02.oneTOoneBi;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(InstructorDetail.class)
public abstract class InstructorDetail_ {

	public static volatile SingularAttribute<InstructorDetail, String> youtubeChannel;
	public static volatile SingularAttribute<InstructorDetail, Instructor> instructor;
	public static volatile SingularAttribute<InstructorDetail, Integer> id;
	public static volatile SingularAttribute<InstructorDetail, String> hobby;

	public static final String YOUTUBE_CHANNEL = "youtubeChannel";
	public static final String INSTRUCTOR = "instructor";
	public static final String ID = "id";
	public static final String HOBBY = "hobby";

}

