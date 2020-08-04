package com.example.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.User;
import com.example.services.UserDaoService;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
	public User retrieveUser(@PathVariable int id) {
		final User user = service.findOne(id);
		return user;
	}
	
	@RequestMapping(path="/users", method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		User savedUser = service.saveUser(user);
		return savedUser;
	}
}
