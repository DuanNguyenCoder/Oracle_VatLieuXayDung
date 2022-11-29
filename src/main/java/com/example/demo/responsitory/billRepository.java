package com.example.demo.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.bill;

@Repository
public interface billRepository extends JpaRepository<bill, Integer> {
	
	
}
