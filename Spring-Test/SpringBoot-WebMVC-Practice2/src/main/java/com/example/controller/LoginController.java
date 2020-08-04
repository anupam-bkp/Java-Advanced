package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.service.LoginService;


@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;
	
	@ModelAttribute
	public void populateModel(@RequestParam String name, @RequestParam String password,
			ModelMap modelMap) {
		modelMap.put("name", name);
		modelMap.put("password", password);
	}
	
	@RequestMapping(value="/validateLogin", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap modelMap, 
				@ModelAttribute("name") String name, @ModelAttribute("password") String password
			/*, 
									@RequestParam String name, @RequestParam String password*/){
	
//		String name = modelMap.get("name").toString();
//		String password = modelMap.get("password").toString();
		
		System.out.println("Name: "+ name + " Password: "+ password);
		
	    boolean isValidUser = service.validateUser(name, password);
	
	    if (!isValidUser) {
	    	modelMap.put("errorMessage", "Invalid Credentials");
	        return "login";
	    }
	
//	    model.put("name", name);
//	    model.put("password", password);
	    
	    return "welcome";
	}

}
