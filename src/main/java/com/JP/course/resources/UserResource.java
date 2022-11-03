package com.JP.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JP.course.entities.User;
import com.JP.course.services.UserService;

//this annotation marks this class as a web resource that is implemented by a rest controller
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service; //dependency
	//testing
	//ResponseEntity is an specific type that respond to web requisitions
	//it uses the path /users
	
	//when we search for localhost:8090, the application shall show us this User u
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")//requisition accepts an id inside the url
	public ResponseEntity<User> findById(@PathVariable Long id){ //@PathVariable allows the method to receive the id in url
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
