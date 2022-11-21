package com.JP.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JP.course.entities.User;
import com.JP.course.repositories.UserRepository;
import com.JP.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		//returns the object (type user) that comes inside the optional, if it doesn't exist, throws our personilized exception
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		UpdateData(entity, obj);
		return repository.save(entity);
	}

	private void UpdateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
