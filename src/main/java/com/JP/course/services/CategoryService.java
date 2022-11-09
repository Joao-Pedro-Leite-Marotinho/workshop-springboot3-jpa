package com.JP.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JP.course.entities.Category;
import com.JP.course.repositories.CategoryRepository;

//register the class as a Spring component so it can be injected automatically
//@Component, @Repository, @Service and so on
@Service
public class CategoryService {
	
	//annotation that solves the dependency
	@Autowired
	private CategoryRepository repository;
	//userRepository is responsible for accessing/modifying data in the database
	
	//this method returns the database categories
	//it uses the "repository" to do this
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		//Optional is a data type
		return obj.get();
		//returns the object (type category) that comes inside the optional
	}

}
