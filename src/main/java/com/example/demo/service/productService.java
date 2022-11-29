package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Product;

public interface productService {

	List<Product> getAllProduct();
	
	void savePro( MultipartFile file,String name,double price,String description,int quantity,int brand, int categories);
	
	void deletePro(Integer id);
	
	void updatePro(String file,int id,String name,double price,String description,int quantity,int brand, int categories) throws SerialException, SQLException;
	
	Optional<Product> findByIdPro(Integer id);
	
}
