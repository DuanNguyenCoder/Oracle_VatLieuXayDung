package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class storeController {
	
	
	@GetMapping("/store/{categories}")
	public String StoreController(@PathVariable("categories") String cateName) {
		return "store";
	}

}
