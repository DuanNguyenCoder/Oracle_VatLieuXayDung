package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detailsBill")
public class detailsBill {

@ManyToOne
@JoinColumn(name = "idBill")
public bill idBill;
	
public int quantity;

@ManyToOne
@JoinColumn(name = "idProduct")
public Product  idProduct;
}
