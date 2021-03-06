package com.anupam.rest.webservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		final User user = service.findOne(id);
		if(null == user) {
			throw new UserNotFoundException("id-"+ id);
		}
		
		return user;
	}
	
	/**
	 * Usage of HATEOAS concept
	 * @return
	 */
	@GetMapping("/user/{id}")
	public EntityModel<User> retrieveOneUser(@PathVariable int id) {
		
		final User user = service.findOne(id);
		if(null == user) {
			throw new UserNotFoundException("id-"+ id);
		}
		
		final EntityModel<User> entityModel = new EntityModel<User>(user);
		final WebMvcLinkBuilder linkTo = 
				WebMvcLinkBuilder.linkTo(
						WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		
		entityModel.add(linkTo.withRel("all-Users"));
		
		return entityModel;
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		User user = service.deleteById(id);
		
		if(user == null) {
			throw new UserNotFoundException("id-" + id);
		}
	}
	
	//input - details of User
	//Output - Create and Return created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.saveUser(user);
		
		URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(savedUser.getId())
					.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
