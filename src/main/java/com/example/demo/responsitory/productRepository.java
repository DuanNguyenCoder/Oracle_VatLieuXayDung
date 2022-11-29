package com.example.demo.responsitory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface productRepository extends JpaRepository<Product, Integer> {
	@Query( value = "select p.*,c.name from product p ,detailscate d,categories c "
			+ "where p.idcate = d.id "
			+ "and d.idcategories = c.id "
			+ "and c.id = :id ",
			countQuery = "select count(*) from product p ,detailscate d,categories c"
			+ "			where p.idcate = d.id "
			+ "			and d.idcategories = c.id "
			+ "			and c.id = :id" , nativeQuery = true)
	public Page<Product> getAllProductByCate(Pageable page, @Param("id") int id);

	@Query( value = "select  p.*,i.image  from product p left outer join image i on i.idproduct = p.id"
			+ "			inner join detailscate d on d.id = p.idcate "
			+ "			inner join categories c on c.id = d.idcategories and c.id = ?1 ",nativeQuery = true)
	public List<Product> getNewProBycate(int id);

}
