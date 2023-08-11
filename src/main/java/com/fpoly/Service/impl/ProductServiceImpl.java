package com.fpoly.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.DAO.ProductDAO;
import com.fpoly.Entity.Product;
import com.fpoly.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO dao;
	
	@Override
	public List<Product> findAll() {
		
		return dao.findAll();
	}

	@Override
	public List<Product> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public Product save(Product pr) {
		return 	dao.save(pr);
	}

	@Override
	public void delete(Integer pr) {
		dao.delete(findById(pr));
	}

}
