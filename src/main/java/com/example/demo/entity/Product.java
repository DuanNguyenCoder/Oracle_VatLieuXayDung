package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	public int id;
	public float price;
	
	
	public int quantity;
	
	public String description;
	
	@Column(name = "productName")
	public String name;
	
	@Column(name = "new")
	public int newP;
	
	@ManyToOne
	@JoinColumn(name = "idCate")
	public detailsCategories idCate;
	
	@ManyToOne
	@JoinColumn(name = "idBrand")
	public brand idBrand;
	
	@ManyToOne
	@JoinColumn(name = "idDiscount")
	public discount idDiscount;
	
	
	@OneToMany(mappedBy = "idProduct" )
	public List<detailsBill> detailsBill;
	
	@OneToMany(mappedBy = "idProduct" )
	public List<image> image;
	
	
	
}
