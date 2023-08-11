package com.fpoly.Service;

import java.util.List;

import com.fpoly.Entity.Product;

public interface ProductService {
	
	List<Product>findAll();
	
	List<Product> findByName(String name);

	Product findById(Integer id);
	
	Product save(Product pr);
	
	void delete(Integer pr);
}
