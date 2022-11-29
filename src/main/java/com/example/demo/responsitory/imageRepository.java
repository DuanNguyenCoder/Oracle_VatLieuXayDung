package com.example.demo.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.image;

@Repository
public interface imageRepository extends JpaRepository<image, Integer> {
	
	
}
