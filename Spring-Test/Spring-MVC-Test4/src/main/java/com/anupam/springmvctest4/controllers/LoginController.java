package com.anupam.springmvctest4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anupam.springmvctest4.services.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/validateUser", method=RequestMethod.POST)
	public String validateUser(@RequestParam String username, 
			@RequestParam String password,
			ModelMap model) {
		
		System.out.println("====== Spring MVC Test 4============");
		System.out.println(username + "::" + password);
		System.out.println("=========================");
		
		boolean validUser = loginService.isValidUser(username, password);
		
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		model.addAttribute("errormessage", "Invalid Credentials");
		
		String resultPage = null;
		
		if(validUser) {
			resultPage = "success";
		}else {
			resultPage = "login";
		}
				
		return resultPage;
	}

	@RequestMapping("/hello")
	public String callHello() {
		return "hello";
	}
}
