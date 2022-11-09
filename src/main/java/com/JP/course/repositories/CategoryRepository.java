package com.JP.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JP.course.entities.Category;
//object repository <Entity, type>
//Spring implements this interface automatically using the type we defined
//it's not necessary to put @Repository, because this interface inherits JpaRepository properties
public interface CategoryRepository extends JpaRepository<Category, Long> {
	//responsible for realizing operations on entity user
	
	
}
