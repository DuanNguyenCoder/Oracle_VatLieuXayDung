package com.example.demo.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.entity.category;
import com.example.demo.responsitory.categoryResponsitory;
import com.example.demo.responsitory.productRepository;

@Controller
public class mainController implements ErrorController {

	@Autowired
	categoryResponsitory cate_repo;
	@Autowired
	productRepository pro_repo;
	
	
	@GetMapping("/")
	public String index( Model model) {
    try {
    	model.addAttribute("listCate",cate_repo.findAll());
    	model.addAttribute("listPro",pro_repo.getall());
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return "index";
	}
	
}
