package com.JP.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JP.course.entities.Product;
import com.JP.course.services.ProductService;

//this annotation marks this class as a web resource that is implemented by a rest controller
@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service; //dependency
	//it uses the path /users
	//when we search for localhost:8090, the application shall show us the users
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//ResponseEntity is an specific type that respond to web requisitions
	}
	
	//finding an element by it's id number
	@GetMapping(value = "/{id}")//requisition accepts an id inside the url
	public ResponseEntity<Product> findById(@PathVariable Long id){
		//@PathVariable allows the method to receive the id in url
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
