package com.example.dbtest.jpa01;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReviewChecklist.class)
public abstract class ReviewChecklist_ {

	public static volatile SingularAttribute<ReviewChecklist, Integer> chlListId;
	public static volatile SingularAttribute<ReviewChecklist, String> reference;
	public static volatile SingularAttribute<ReviewChecklist, Integer> chkListPos;
	public static volatile SingularAttribute<ReviewChecklist, String> description;
	public static volatile SingularAttribute<ReviewChecklist, ReviewType> rvwType;
	public static volatile SingularAttribute<ReviewChecklist, String> tip;
	public static volatile SingularAttribute<ReviewChecklist, Date> updatedOn;
	public static volatile SingularAttribute<ReviewChecklist, Category> category;
	public static volatile SingularAttribute<ReviewChecklist, Employee> employee;
	public static volatile SingularAttribute<ReviewChecklist, ResultType> resultType;
	public static volatile SingularAttribute<ReviewChecklist, ChkListType> chkListType;

	public static final String CHL_LIST_ID = "chlListId";
	public static final String REFERENCE = "reference";
	public static final String CHK_LIST_POS = "chkListPos";
	public static final String DESCRIPTION = "description";
	public static final String RVW_TYPE = "rvwType";
	public static final String TIP = "tip";
	public static final String UPDATED_ON = "updatedOn";
	public static final String CATEGORY = "category";
	public static final String EMPLOYEE = "employee";
	public static final String RESULT_TYPE = "resultType";
	public static final String CHK_LIST_TYPE = "chkListType";

}

