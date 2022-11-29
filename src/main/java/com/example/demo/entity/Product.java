package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

@Table(name ="product")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public double price;
	
	
	public int quantity;
	
	public String description;
	
	@Column(name = "productname")
	public String name;
	
	@Column(name = "new")
	public int newP;
	
	
	@ManyToOne
	@JoinColumn(name = "idcate")
	//@JsonBackReference
	
	public detailsCategories idCate;

	
	@ManyToOne
	@JoinColumn(name = "idbrand")
	//@JsonBackReference
	public brand idBrand;
	
	
	@ManyToOne
	@JoinColumn(name = "iddiscount")
   // @JsonBackReference
   
	public discount idDiscount;
	
	
	@OneToMany(mappedBy = "idProduct" )
	@JsonManagedReference
	public List<detailsBill> detailsBill;
	
	@OneToMany(mappedBy = "idProduct" )
	@JsonManagedReference
	public List<image> image;
	

}
