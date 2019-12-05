package com.anupam.springmvctest2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	protected String sayHello(){
		
		System.out.println("Calling Hello");
		
		return "hello";
	}
	
}
