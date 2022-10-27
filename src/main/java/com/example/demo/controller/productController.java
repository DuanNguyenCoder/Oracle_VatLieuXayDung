package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class productController {

	@GetMapping("/detail")
	public String ProductController() {
		return "product";
	}
}
