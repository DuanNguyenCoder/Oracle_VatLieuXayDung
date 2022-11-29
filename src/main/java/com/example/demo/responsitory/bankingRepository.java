package com.example.demo.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.banking;

@Repository
public interface bankingRepository extends JpaRepository<banking, Integer> {
	
	
}
