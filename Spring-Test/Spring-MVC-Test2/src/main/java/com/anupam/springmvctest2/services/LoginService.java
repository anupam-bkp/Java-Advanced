package com.anupam.springmvctest2.services;

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
