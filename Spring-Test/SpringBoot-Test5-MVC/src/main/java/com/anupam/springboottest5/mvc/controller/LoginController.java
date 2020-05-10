package com.anupam.springboottest5.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anupam.springboottest5.mvc.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login")
	public String login() {
		return "";
	}
	
	@RequestMapping(value="/hello")
	@ResponseBody
	public String sayHelloWorld() {
		return "Hello World";
	}
}
