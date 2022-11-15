package com.JP.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JP.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
	
	
}