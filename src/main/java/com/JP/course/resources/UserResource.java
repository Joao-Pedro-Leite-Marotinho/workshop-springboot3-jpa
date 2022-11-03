package com.JP.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JP.course.entities.User;

//this annotation marks this class as a web resource that is implemented by a rest controller
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//testing
	//ResponseEntity is an specific type that respond to web requisitions
	//it uses the path /users
	
	//testing
	//when we search for localhost:8090, the application shall show us this User u
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345");
		return ResponseEntity.ok().body(u);
	}
	
}
