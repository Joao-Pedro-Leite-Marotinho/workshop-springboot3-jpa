package com.JP.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JP.course.entities.User;

//object repository <Entity, type>
//Spring implements this interface automatically using the type we defined
public interface UserRepository extends JpaRepository<User, Long> {
	//responsible for realizing operations on entity user
	
	
}
