package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {
	
	
	@GetMapping("/Manager")
	public String Dashboard() {
		
		return "DashboardManager";
	}

}
