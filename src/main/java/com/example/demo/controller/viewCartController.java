package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Product;
import com.example.demo.entity.itemCart;
import com.example.demo.responsitory.productRepository;
import com.example.demo.service.ItemCartService;
import com.example.demo.service.productService;

@Controller
public class viewCartController {
	
	@Autowired
	ItemCartService item;
	
	@Autowired
	productService product;
	
	@GetMapping("/Cart")
	public String view() {
		return "checkout";
	}
	
	@GetMapping("list")
	public String list() {
		return "";
	}

	
	@RequestMapping(value = "viewcart/add", method = RequestMethod.GET)
	public @ResponseBody Collection<itemCart>   add(int productID) {
		try {
			System.out.println(productID);
			Product p = product.findByIdPro(productID).get();
			
			
			itemCart cart = new itemCart(p.id,p.name,p.price,p.description,p.idCate.nameDetailCate,1);
			
			item.add(cart);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return item.getList();
		
	}
	
	@PostMapping("viewcart/remove")
	public @ResponseBody Object[]  remove(int itemId) {
	item.remove(itemId);
	
	Object[] ob  = {item.getAmount(),item.getsize()};
		return ob;
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
