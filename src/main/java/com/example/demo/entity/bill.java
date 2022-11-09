package com.example.demo.entity;

import java.sql.Date;
import java.util.List;

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
@Table(name ="bill")
public class bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public Date orderDate;
	public String otherNotes;
	public float total;
	
	@ManyToOne
	@JoinColumn(name = "idBank")
	public banking idBank;
	@ManyToOne
	@JoinColumn(name = "customer")
	public customer idCustomer;
	
	@OneToMany(mappedBy = "idBill")
	public List<detailsBill> detailsBills;
	
}
