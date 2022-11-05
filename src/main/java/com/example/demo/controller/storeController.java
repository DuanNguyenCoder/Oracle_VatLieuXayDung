package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class storeController {

	
	@GetMapping( value = "/store/{id}")
	public String deleteStudentPage(@PathVariable("id") int id) {
		
		return "store";
	}
}
