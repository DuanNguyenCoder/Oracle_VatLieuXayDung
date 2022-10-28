package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	public int id;
	public float price;
	
	@Column(name = "productname")
	public String name;
	public String description;
	
	@ManyToOne
	@JoinColumn(name = "idcate")
	public category idCate;
	
	@Column(name = "new")
	public int newP;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public category getIdCate() {
		return idCate;
	}
	public void setIdCate(category idCate) {
		this.idCate = idCate;
	}
	public int getNewP() {
		return newP;
	}
	public void setNewP(int newP) {
		this.newP = newP;
	}
	
	public Product(int id, String name, float price, String description, category idCate, int newP) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
		this.description = description;
		this.idCate = idCate;
		this.newP = newP;
	}
	public Product() {
		super();
	}
}
