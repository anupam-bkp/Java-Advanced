package com.anupam.springmvctest3.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.anupam.springwebmvctest3.command.User;

public class UserValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		User user = (User)target;
		
		if(user.getUsername() == null || user.getUsername().length() == 0) {
			errors.rejectValue("username", "error.username.required", null, "Username required");
		}
		
		if(user.getPassword() == null || user.getPassword().length() == 0) {
			errors.rejectValue("password", "error.password.required", null, "Password required");
		}
	}
}
