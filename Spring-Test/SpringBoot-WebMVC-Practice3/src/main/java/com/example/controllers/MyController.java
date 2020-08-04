package com.example.controllers;

import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.models.MyCommandBean;

@Controller
@SessionAttributes("myRequestObject")
public class MyController {

	@ModelAttribute("myRequestObject")
	public MyCommandBean addStuffToRequestScope() {
		System.out.println("Inside addStuffToRequestScope");
		final MyCommandBean myCommandBean = new MyCommandBean("Hello World", 42);
		return myCommandBean;
	}
	
	@RequestMapping(value="/doSomething", method = RequestMethod.GET)
	public String requestHandlingMethod(Model model, 
			HttpServletRequest request, HttpSession session) {
		
		System.out.println("MyController.requestHandlingMethod()");
		
		System.out.println("====Model Data======");
		
		final Map<String, Object> modelMap = model.asMap();
		for(Entry<String, Object> entry : modelMap.entrySet()) {
			System.out.println(entry.getKey() + " -- " + entry.getValue().toString());
		}
		
		System.out.println("=========Request Data ===========");
		final Enumeration<String> attributeNames = request.getAttributeNames();
		
		while(attributeNames.hasMoreElements()) {
			String nextElement = attributeNames.nextElement();
			System.out.println(nextElement);
			System.out.println(" == " + request.getAttribute(nextElement));
		}
		
		 System.out.println("***** Session data ******");
		  Enumeration<String> e = session.getAttributeNames();
		  while (e.hasMoreElements()){
			String s = e.nextElement();
			System.out.println(s);
			System.out.println("**" + session.getAttribute(s));
		  }
		
		return "nextpage";
	}
	
	
}
