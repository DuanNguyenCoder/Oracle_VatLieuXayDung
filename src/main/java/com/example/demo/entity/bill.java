package com.example.demo.entity;

import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="bill")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	@Column(name = "orderdate")
	public Date orderDate;
	
	@Column(name = "othernotes")
	public String otherNotes;
	
	public float total;
	
	
	@ManyToOne
	@JoinColumn(name = "idbank")
	@JsonBackReference
	public banking idBank;
	
	@ManyToOne
	@JoinColumn(name = "idcustomer")
	@JsonBackReference
	public customer idCustomer;
	
	@OneToMany(mappedBy = "idBill")
	@JsonManagedReference
	public List<detailsBill> detailsBills;
	
}
