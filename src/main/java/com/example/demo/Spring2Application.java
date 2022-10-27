package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Spring2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("success");
		
	}

}
