package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detailsbill")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class detailsBill {
	
	@ManyToOne
	@JoinColumn(name = "idbill")
	@JsonBackReference
	public bill idBill;
	
	public int quantity;
	
	@ManyToOne
	@JoinColumn(name = "idproduct")
	@JsonBackReference
	public Product  idProduct;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;



}
