package com.example.demo.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.detailsCategories;

@Repository
public interface detailsCateRepository extends JpaRepository<detailsCategories, Integer> {
	
	
}
