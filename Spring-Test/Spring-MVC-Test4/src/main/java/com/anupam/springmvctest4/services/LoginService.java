package com.anupam.springmvctest4.services;

import org.springframework.stereotype.Controller;

@Controller
public class LoginService {

public boolean isValidUser(String userName, String password) {
		
		boolean validUser = false;
		
		if("anupam".equalsIgnoreCase(userName)) {
			if("1234".equalsIgnoreCase(password)) {
				validUser = true;
			}
		}
		
		return validUser;
	}
	
}
