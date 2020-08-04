package com.example.dbtest.jpa01;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MyMetadataBuilderContributor implements MetadataBuilderContributor{

	@Override
	public void contribute(MetadataBuilder metadataBuilder) {

		metadataBuilder.applySqlFunction("instr", 
				new StandardSQLFunction( "instr", StandardBasicTypes.STRING ));
	}

}
