package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Product;
import com.example.demo.responsitory.categoryResponsitory;
import com.example.demo.responsitory.productRepository;
import com.example.demo.service.ItemCartService;


@Controller
public class mainController  {

	@Autowired
	categoryResponsitory cate_repo;
	
	@Autowired
	productRepository pro_repo;
	
	@Autowired
	ItemCartService item;
	
	@GetMapping("/")
	public String index( Model model) {
    	model.addAttribute("listCate",cate_repo.findAll());
    	model.addAttribute("listPro",pro_repo.findAll());
    	model.addAttribute("listViewCart",item.getList());
    	model.addAttribute("viewCartAmount",item.getAmount());
    	model.addAttribute("viewCartSize",item.getsize());
		return "index";
	}
	
	@RequestMapping( value = "/getNewPro",method = RequestMethod.GET)
	public @ResponseBody List<Product> getNewProByCate(  int idCate) throws Exception{
		return pro_repo.getNewProBycate(idCate);
	}
	
}
