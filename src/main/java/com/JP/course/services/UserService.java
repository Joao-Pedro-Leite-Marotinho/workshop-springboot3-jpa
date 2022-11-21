package com.JP.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JP.course.entities.User;
import com.JP.course.repositories.UserRepository;

//register the class as a Spring component so it can be injected automatically
//@Component, @Repository, @Service and so on
@Service
public class UserService {
	
	//annotation that solves the dependency
	@Autowired
	private UserRepository repository;
	//userRepository is responsible for accessing/modifying data in the database
	
	//this method returns the database users
	//it uses the "repository" to do this
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		//Optional is a data type
		return obj.get();
		//returns the object (type user) that comes inside the optional
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
