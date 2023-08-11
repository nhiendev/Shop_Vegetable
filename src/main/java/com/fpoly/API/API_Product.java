package com.fpoly.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.DAO.ProductDAO;
import com.fpoly.Entity.Category;
import com.fpoly.Entity.Item;
import com.fpoly.Entity.Product;
import com.fpoly.Service.CartService;

@CrossOrigin("*")
@RestController
public class API_Product {
	
	@Autowired
	ProductDAO dao;
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/api/product")
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok(dao.findAll());
	}
	@GetMapping("/api/product/best-seller")
	public List<Product> getProductSeller() {
		return dao.findAll();
	}
	
	@GetMapping("/api/product/{id}")
	ResponseEntity<Product> getOneProduct(@PathVariable("id") Integer id) {
		if(!dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dao.findById(id).get());

	} 
	@GetMapping("/api/product/category/{category}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("category") Category category) {
		return ResponseEntity.ok(dao.findByCategoryId(category));
	}
	
	@GetMapping("/api/product/addtocart/{id}")
	public Item cart(@PathVariable("id") Integer id){
		return cartService.addCart(id);
	}
	
	@GetMapping("/api/product/addtocart/count")
	public int cartCount(){
		return cartService.getCount();
	}
}

