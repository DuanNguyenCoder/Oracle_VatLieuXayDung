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
@Table(name ="banking")
public class banking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String bankName;
	
	@OneToMany(mappedBy = "idBank")
	public List<bill> bill;
}
