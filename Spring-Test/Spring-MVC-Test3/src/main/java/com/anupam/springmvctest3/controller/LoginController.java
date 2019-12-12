package com.anupam.springmvctest3.controller;

import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.anupam.springmvctest3.validator.UserValidator;
import com.anupam.springwebmvctest3.command.User;

@Controller
@SessionAttributes
public class LoginController {

	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value="/verifyUser", method=RequestMethod.POST)
	public String verifyUser(@ModelAttribute("user") User user, BindingResult result) {
		
		System.out.println("LoginController.verifyUser()");
		
		userValidator.validate(user, result);
		
		if(result.hasErrors()) {
			System.out.println(result.getErrorCount());
			return "login";
		}
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		System.out.println(username);
		System.out.println(password);
		
		if(!username.equals(password)) {
			return "login";
		}
		
		return "home";
	}
	
	@RequestMapping("/login")
	public String showLoginForm(Map<String, User> model) throws ServletException {
		
		System.out.println("LoginController.showLoginForm()");
		
		User user = new User();
		user.setUsername("anupam");
		model.put("user", user);
		
		return "login";
		
	}
	
}
