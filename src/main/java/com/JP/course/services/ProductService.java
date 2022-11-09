package com.JP.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JP.course.entities.Product;
import com.JP.course.repositories.ProductRepository;

//register the class as a Spring component so it can be injected automatically
//@Component, @Repository, @Service and so on
@Service
public class ProductService {
	
	//annotation that solves the dependency
	@Autowired
	private ProductRepository repository;
	//userRepository is responsible for accessing/modifying data in the database
	
	//this method returns the table products
	//it uses the "repository" to do this
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		//Optional is a data type
		return obj.get();
		//returns the object (type product) that comes inside the optional
	}

}
