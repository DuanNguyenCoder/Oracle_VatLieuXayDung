package com.example.demo.responsitory;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface categoryResponsitory extends  JpaRepository<category, Integer>  {

	@Query(value = "select * from categories", nativeQuery = true)
	public List<category> getall();
}
