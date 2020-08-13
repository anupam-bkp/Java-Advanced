package com.example.dbtest.review;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProjectDetail.class)
public abstract class ProjectDetail_ {

	public static volatile SingularAttribute<ProjectDetail, Project> project;
	public static volatile SingularAttribute<ProjectDetail, Employee> employee1;
	public static volatile SingularAttribute<ProjectDetail, ProjectStatus> projStatus;
	public static volatile SingularAttribute<ProjectDetail, Date> updatedOn;
	public static volatile SingularAttribute<ProjectDetail, String> projectName;
	public static volatile SingularAttribute<ProjectDetail, Employee> employee2;

	public static final String PROJECT = "project";
	public static final String EMPLOYEE1 = "employee1";
	public static final String PROJ_STATUS = "projStatus";
	public static final String UPDATED_ON = "updatedOn";
	public static final String PROJECT_NAME = "projectName";
	public static final String EMPLOYEE2 = "employee2";

}

