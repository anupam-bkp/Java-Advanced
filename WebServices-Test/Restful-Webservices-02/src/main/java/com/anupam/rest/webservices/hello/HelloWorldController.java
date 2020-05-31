package com.anupam.rest.webservices.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
//	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "This is Hello World Application!";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("This Hellow World id from Bean!");
	}
	
	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public HelloWorldBean getHelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello from, %s", name));
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized(
			@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		
		return messageSource.getMessage("good.morning.message", null,
				locale);
	}
	
	@GetMapping(path="/hello-world-international")
	public String helloWorldInternational() {
		
		return messageSource.getMessage("good.morning.message", null,
				LocaleContextHolder.getLocale());
	}
}
