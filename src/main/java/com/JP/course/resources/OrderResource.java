package com.JP.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JP.course.entities.Order;
import com.JP.course.services.OrderService;

//this annotation marks this class as a web resource that is implemented by a rest controller
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service; //dependency
	//it uses the path /orders
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//ResponseEntity is an specific type that respond to web requisitions
	}
	
	//finding an element by it's id number
	@GetMapping(value = "/{id}")//requisition accepts an id inside the url
	public ResponseEntity<Order> findById(@PathVariable Long id){
		//@PathVariable allows the method to receive the id in url
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
