package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
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
@Entity
@Table(name ="customer")
public class customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	public String firstName;
	public String lastName;
	public String email;
	public String address;
	public String city;
	public String country;
	public String phone;
	
	@OneToMany(mappedBy = "idCustomer")
	public List<bill> bill;
}
