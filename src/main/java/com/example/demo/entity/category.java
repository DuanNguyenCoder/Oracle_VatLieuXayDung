package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "categories")
public class category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public int id;
	public String name;
	
	@OneToMany(mappedBy = "idCate" )
	public List<Product> products;
	
	public category() {
		super();
	}
	public category(int id, String nameString, List<Product> products) {
		super();
		this.id = id;
		this.name = nameString;
		this.products = products;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String nameString) {
		this.name = nameString;
	}
}
