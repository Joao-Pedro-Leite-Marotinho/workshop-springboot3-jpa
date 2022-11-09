package com.JP.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JP.course.entities.Order;
import com.JP.course.repositories.OrderRepository;

//register the class as a Spring component so it can be injected automatically
//@Component, @Repository, @Service and so on
@Service
public class OrderService {
	
	//annotation that solves the dependency
	@Autowired
	private OrderRepository repository;
	//orderRepository is responsible for accessing/modifying data in the database
	
	//this method returns the table orders
	//it uses the "repository" to do this
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		//Optional is a data type
		return obj.get();
		//returns the object (type user) that comes inside the optional
	}

}
