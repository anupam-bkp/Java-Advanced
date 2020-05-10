package com.anupam.springboottest5.mvc.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateUser(String password) {
		return "1234".equalsIgnoreCase(password);
	}
}
