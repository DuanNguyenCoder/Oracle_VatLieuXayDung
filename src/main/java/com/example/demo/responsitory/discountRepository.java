package com.example.demo.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.discount;

@Repository
public interface discountRepository extends JpaRepository<discount, Integer> {
	
	
}
