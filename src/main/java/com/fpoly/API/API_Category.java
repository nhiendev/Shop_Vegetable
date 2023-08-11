package com.fpoly.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.DAO.CategoryDAO;
import com.fpoly.Entity.Category;

@CrossOrigin("*")
@RestController
public class API_Category {
	
	@Autowired
	CategoryDAO dao;
	
	@GetMapping("/api/category")
	public ResponseEntity<List<Category>> getAll() {
		return ResponseEntity.ok(dao.findAll());
	}
	
	@GetMapping("/api/category/{id}")
	public ResponseEntity<Category> findByIdCate(@PathVariable("id") String id) {
		if(!dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dao.findById(id).get());
	}
	
	@PostMapping("/api/category")
	public ResponseEntity<Category> save(@RequestBody Category category) {
		if(dao.existsById(category.getId())) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(dao.save(category));
	}
	
	@PutMapping("/api/category/{id}")
	public ResponseEntity<Category> update(@PathVariable("id") String id,@RequestBody Category category, Model model) {
		if(!dao.existsById(id)) {
			model.addAttribute("message", false);
			return ResponseEntity.badRequest().build();
		}else {
			model.addAttribute("message", true);
		}
		return ResponseEntity.ok(dao.save(category));
	}
	
	@DeleteMapping(value = "/api/category/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id){
		if (!dao.existsById(id)) { // kiểm tra đã có trong SQL chưa
			return ResponseEntity.notFound().build();
		}else {
			dao.deleteById(id);
		}
		
		return ResponseEntity.ok().build();
	}
}
