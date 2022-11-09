package com.example.demo.entity;

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
@Table(name = "detailscate")
public class detailsCategories {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO )
public int id;
public String nameDetailCate;

@ManyToOne
@JoinColumn(name = "idCategories")
public category  idCategories;

@OneToMany(mappedBy = "idCate" )
public List<Product> products;
}
