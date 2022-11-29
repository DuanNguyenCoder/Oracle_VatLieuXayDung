package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class ManagerController {
	

	
	@GetMapping("/Manager")
	public String Dashboard(Model model) {
	
		return "DashboardManager";
	}
}
