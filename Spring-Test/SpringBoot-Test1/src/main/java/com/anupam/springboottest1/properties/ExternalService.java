package com.anupam.springboottest1.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExternalService {

	//Read value from property file
	@Value("${external.service.url}")
	private String url;
	
	public String getUrl() {
		return url;
	}
	
}
