package com.example.demo.controller;

import java.util.Optional;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Product;
import com.example.demo.responsitory.productRepository;
import com.example.demo.service.productService;

@Controller
public class productController {

	@Autowired
	productRepository proRepo;
	
	@Autowired
	productService productSer;
	
	
	
	@GetMapping("/detail")
	public String ProductController() {
		return "product";
	}
	
	
	@GetMapping("store/test")
	public @ResponseBody Page<Product> Paginate(Model model, @RequestParam("p") Optional<Integer> p) {
	Pageable pageable = PageRequest.of(p.orElse(0),9);
	Page<Product> page = proRepo.findAll(pageable);
	
	return page; 
	}
}
