package com.anupam.springmvctest2.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anupam.springmvctest2.services.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login")
	protected ModelAndView authenticate(HttpServletRequest request) {
		final String userName = request.getParameter("username");
		final String password = request.getParameter("password");
		
		System.out.println("====== Spring MVC Test 2============");
		System.out.println(userName + "::" + password);
		System.out.println("=========================");
		
		boolean validUser = loginService.isValidUser(userName, password);
		
		String resultPage = null;
		
		if(validUser) {
			resultPage = "success";
		}else {
			resultPage = "failure";
		}
		
		return new ModelAndView(resultPage, "User", validUser);
	}
	
	
}
