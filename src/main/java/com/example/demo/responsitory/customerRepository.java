package com.example.demo.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.customer;


@Repository
public interface customerRepository extends JpaRepository<customer, Integer> {
	
	
}
