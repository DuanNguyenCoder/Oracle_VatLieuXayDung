package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.itemCart;
import com.example.demo.responsitory.itemCartRepository;
import com.example.demo.responsitory.productRepository;

@Controller
public class viewCartController {
	
	
	itemCartRepository item = new itemCartRepository() ;
	
	@Autowired
	productRepository product;
	
	@GetMapping("/Cart")
	public String view() {
		return "checkout";
	}
	
	@GetMapping("list")
	public String list() {
		return "";
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public @ResponseBody Collection<itemCart>   add(int productID) {
		try {
			System.out.println(productID);
			Object[] p = product.findById(productID);
			Object[] p2 = (Object[])p[0];
			
			int id = ( (BigDecimal)p2[0]).intValue();
			int price = ( (BigDecimal)p2[4]).intValue();
			
			
			itemCart cart = new itemCart(id,(String)p2[1],price,(String)p2[2],(String)p2[7],1);
			
			item.add(cart);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return item.getList();
		
	}
	
	@GetMapping("remove")
	public String remove() {
		return "";
	}
	
	@GetMapping("update")
	public String update() {
		return "";
	}

	@GetMapping("clear")
	public String clear() {
		return "";
	}
}
