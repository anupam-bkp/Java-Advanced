package com.example.dbtest.jpa01;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReviewType.class)
public abstract class ReviewType_ {

	public static volatile SingularAttribute<ReviewType, String> rvwTypeName;
	public static volatile SingularAttribute<ReviewType, Integer> rvwTypeId;
	public static volatile SingularAttribute<ReviewType, Date> updatedOn;
	public static volatile SingularAttribute<ReviewType, ProjectDetail> projectDetail;
	public static volatile SingularAttribute<ReviewType, Employee> employee;

	public static final String RVW_TYPE_NAME = "rvwTypeName";
	public static final String RVW_TYPE_ID = "rvwTypeId";
	public static final String UPDATED_ON = "updatedOn";
	public static final String PROJECT_DETAIL = "projectDetail";
	public static final String EMPLOYEE = "employee";

}

