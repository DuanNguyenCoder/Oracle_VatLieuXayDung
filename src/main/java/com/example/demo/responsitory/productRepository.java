package com.example.demo.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface productRepository extends JpaRepository<Product, Integer> {
	@Query(value = "select p.productname,p.price,c.name from product p inner join categories c on p.id = c.id", nativeQuery = true)
	public List<Object[]> getall();
}
