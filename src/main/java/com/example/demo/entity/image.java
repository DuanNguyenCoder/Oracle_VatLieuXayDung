package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="image")
public class image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	@ManyToOne
	@JoinColumn(name = "idProduct")
	public Product idProduct;
	
	 @Lob
	    @Column(name = "image", columnDefinition="BLOB")
	    private byte[] image;
}
