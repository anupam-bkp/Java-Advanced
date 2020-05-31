package com.anupam.rest.webservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UserJPAResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		
		final Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+ id);
		}
		
		return user.get();
	}
	
	/**
	 * Usage of HATEOAS concept
	 * @return
	 */
	@GetMapping("/jpa/user/{id}")
	public EntityModel<User> retrieveOneUser(@PathVariable int id) {
		
		final Optional<User> user = userRepository.findById(id);
		
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+ id);
		}
		
		final EntityModel<User> entityModel = new EntityModel<User>(user.get());
		final WebMvcLinkBuilder linkTo = 
				WebMvcLinkBuilder.linkTo(
						WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		
		entityModel.add(linkTo.withRel("all-Users"));
		
		return entityModel;
	}
	
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	//input - details of User
	//Output - Create and Return created URI
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(savedUser.getId())
					.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUserPosts(@PathVariable int id){
		
		final Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+ id);
		}
		
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	private ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		
		final Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+ id);
		}
		
		post.setUser(user.get());
		
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(post.getId())
				.toUri();
	
		return ResponseEntity.created(location).build();
	}
	
}
