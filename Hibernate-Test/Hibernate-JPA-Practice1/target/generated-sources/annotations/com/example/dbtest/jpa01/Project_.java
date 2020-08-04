package com.example.dbtest.jpa01;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Project.class)
public abstract class Project_ {

	public static volatile SingularAttribute<Project, String> projectName;
	public static volatile SingularAttribute<Project, Integer> projectId;

	public static final String PROJECT_NAME = "projectName";
	public static final String PROJECT_ID = "projectId";

}

