package com.anupam.springmvctest1.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.anupam.springmvctest1.services.LoginService;


public class LoginController extends AbstractController{

	@Autowired
	LoginService loginService;
	
	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		final String userName = request.getParameter("username");
		final String password = request.getParameter("password");
		
		System.out.println("==========================");
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
