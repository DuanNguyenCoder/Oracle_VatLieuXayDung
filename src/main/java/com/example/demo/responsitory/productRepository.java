package com.example.demo.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface productRepository extends JpaRepository<Product, Integer> {
	@Query(value = "select p.id, p.productname,p.price,c.name from product p inner join categories c on p.id = c.id", nativeQuery = true)
	public List<Object[]> getall();
	
	@Query(value = "select p.id as p_id, p.productname,p.description,p.new,p.price,p.idcate,c.* from product p inner join categories c on p.id = c.id and p.id = :id", nativeQuery = true)
	public Object[] findById(int id);
	
}
