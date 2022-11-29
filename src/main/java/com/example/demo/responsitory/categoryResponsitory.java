package com.example.demo.responsitory;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
import com.example.demo.entity.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface categoryResponsitory extends  JpaRepository<category, Long>  {

	@Query(value = "select * from categories", nativeQuery = true)
	public List<category> getall();
	
	@Query( value = "select  p.*,i.image  from product p left outer join image i on i.idproduct = p.id"
			+ "			inner join detailscate d on d.id = p.idcate "
			+ "			inner join categories c on c.id = d.idcategories and c.id = 3 ",nativeQuery = true)
	public List<category> getNewProBycate(int id);
}
