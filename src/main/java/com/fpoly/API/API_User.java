package com.fpoly.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.DAO.UserDAO;
import com.fpoly.Entity.Users;

@CrossOrigin("*")
@RestController
public class API_User {
	
	@Autowired
	UserDAO dao;
	
	@GetMapping("/api/user")
	public ResponseEntity<List<Users>> getAll() {
		return ResponseEntity.ok(dao.findAll());
	}
}
