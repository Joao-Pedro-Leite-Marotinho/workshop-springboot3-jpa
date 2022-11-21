package com.JP.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.JP.course.entities.User;
import com.JP.course.services.UserService;

//this annotation marks this class as a web resource that is implemented by a rest controller
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service; //dependency
	//it uses the path /users
	//when we search for localhost:8090, the application shall show us the users
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//ResponseEntity is an specific type that respond to web requisitions
	}
	
	//finding an element by it's id number
	@GetMapping(value = "/{id}")//requisition accepts an id inside the url
	public ResponseEntity<User> findById(@PathVariable Long id){
		//@PathVariable allows the method to receive the id in url
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//@RequestBody makes the User obj that comes in Json format become a java object
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
