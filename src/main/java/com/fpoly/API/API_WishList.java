package com.fpoly.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.DAO.FavoriteDAO;
import com.fpoly.Entity.Favorite;
@CrossOrigin("*")
@RestController
public class API_WishList {

	@Autowired
	FavoriteDAO dao;
	
	@GetMapping("/api/favorite")
	public ResponseEntity<List<Favorite>> getAll(){
		return ResponseEntity.ok(dao.findAll());
	}
	
	@DeleteMapping("/api/favorite/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		if(dao.existsById(id)) {
			ResponseEntity.notFound().build();
		}else {
			dao.deleteById(id);
		}
		
		return ResponseEntity.ok().build();
	}
}
