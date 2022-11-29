package com.example.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;

import com.example.demo.responsitory.categoryResponsitory;
import com.example.demo.responsitory.imageRepository;
import com.example.demo.responsitory.productRepository;


@RestController
public class testController {

	@Autowired
	categoryResponsitory cate_repo;
	@Autowired
	productRepository proRepo;
	@Autowired
	imageRepository img;
	
	@GetMapping("/test/getPage")
	public Page<Product> getNewProByCate( @RequestParam(name = "p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0),2);
		Page<Product> page = proRepo.getAllProductByCate(pageable,3);
		
		return page;
	}
}
