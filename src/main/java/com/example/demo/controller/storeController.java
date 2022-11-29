package com.example.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Product;
import com.example.demo.responsitory.categoryResponsitory;
import com.example.demo.responsitory.detailsCateRepository;
import com.example.demo.responsitory.productRepository;
import com.example.demo.service.ItemCartService;
import com.example.demo.service.productService;

@Controller
public class storeController {

	@Autowired
	productService productSer;
	@Autowired
	detailsCateRepository detailCateRepo;
	@Autowired
	productRepository productRepo;
	@Autowired
	categoryResponsitory cateRepo;
	@Autowired
	ItemCartService item;
	
	
	@GetMapping( value = "/store/{id}")
	public String getStore(@PathVariable("id") int id,  Model model, @RequestParam(name = "p",defaultValue = "0",required = false) Optional<Integer> pageNum) {
		
		model.addAttribute("listDetail",detailCateRepo.findAll());
		model.addAttribute("listCate",cateRepo.findAll());
		model.addAttribute("listViewCart",item.getList());
    	model.addAttribute("viewCartAmount",item.getAmount());
    	model.addAttribute("viewCartSize",item.getsize());
		
		Pageable pageable = PageRequest.of(pageNum.orElse(0),2);
		System.out.println(id);
		Page<Product> page = productRepo.getAllProductByCate(pageable,id);
     	model.addAttribute("listPro",page);
		return "store";
	}
}
