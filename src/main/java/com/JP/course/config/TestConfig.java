package com.JP.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.JP.course.entities.User;
import com.JP.course.repositories.UserRepository;

//indicates this is a configuration class
@Configuration
//indicate this is the profile we put in application properties: spring.profiles.active=test
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	//annotation that solves the dependency
	@Autowired
	private UserRepository userRepository; //atributte associated

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		//userRepository is responsible for accessing/modifying data in the database
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}
