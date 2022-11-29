package com.example.demo.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.detailsBill;


@Repository
public interface detailsbilRepository extends JpaRepository<detailsBill, Integer> {
	
	
}
