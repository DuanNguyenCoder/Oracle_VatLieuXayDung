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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detailscate")

public class detailsCategories  {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public int id;


@ManyToOne
@JoinColumn(name = "idcategories")
@JsonBackReference
public category  idCategories;

@Column(name = "namedetailcate")
public String nameDetailCate;



@OneToMany(mappedBy = "idCate" )
//@JsonManagedReference
@JsonIgnore
public List<Product> products;
}
