package com.anupam.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.anupam.ecommerce.entities.Product;
import com.anupam.ecommerce.entities.ProductCategory;

/**
 * Class to disable PUT, DELETE and POST REST Api
 *
 */

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config);
		
		HttpMethod[] theUnsupportedActions = 
			{HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
		
		//Disable HTTP methods for Product: PUT, POST and DELETE
		
		config.getExposureConfiguration().forDomainType(Product.class)
		.withItemExposure((metadata, httpMethods) -> 
							httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metaData, httpMethods) -> 
							httpMethods.disable(theUnsupportedActions));
		
		//Disable HTTP methods for ProductCategory: PUT, POST and DELETE
		
		config.getExposureConfiguration().forDomainType(ProductCategory.class)
		.withItemExposure((metadata, httpMethods) -> 
							httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metaData, httpMethods) -> 
							httpMethods.disable(theUnsupportedActions));
		
	}
}
