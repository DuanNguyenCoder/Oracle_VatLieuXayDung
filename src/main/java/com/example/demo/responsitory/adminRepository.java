package com.example.demo.responsitory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.admin;

@Repository
public interface adminRepository extends JpaRepository<admin, Integer> {
	
	
}