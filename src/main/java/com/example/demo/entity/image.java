package com.example.demo.entity;

import java.sql.Blob;
import java.sql.SQLException;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="image")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
    
	@ManyToOne
	@JoinColumn(name = "idproduct")
	@JsonBackReference
	public Product idProduct;
	
	
	@Lob
	@Column(name = "image",columnDefinition = "BLOB")
	@JsonIgnore
	public Blob image;
	
	
	@JsonProperty
	public String convertBlobToBase64() throws SQLException {
		Blob blob = this.image;
		int blobLength;
		blobLength = (int)image.length();
		
	byte[] bytes =	blob.getBytes(1,blobLength );
		String blobString = new String(bytes);
		System.out.println(blobString);

		  return blobString;
		 
	}
}
