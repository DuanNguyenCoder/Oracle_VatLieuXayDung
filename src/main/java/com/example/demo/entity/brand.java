package com.example.demo.entity;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Table(name = "brand")
	public class brand {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	public int id;
	public String name;
	
	@OneToMany(mappedBy = "idBrand")
	public List<Product> product;
	}

