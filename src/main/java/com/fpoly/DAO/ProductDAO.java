package com.fpoly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.Entity.Category;
import com.fpoly.Entity.Product;
@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{
	
	
	List<Product> findByName(String name);
	
	List<Product> findByCategoryId(Category  categoryId);

}
