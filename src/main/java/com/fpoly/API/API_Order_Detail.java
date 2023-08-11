package com.fpoly.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.DAO.Order_DetailDAO;
import com.fpoly.Entity.Order_Detail;

@CrossOrigin("*")
@RestController
public class API_Order_Detail {
	
	@Autowired
	Order_DetailDAO dao;
	
	@GetMapping("/api/order-detail")
	public ResponseEntity<List<Order_Detail>> getAll() {
		return ResponseEntity.ok(dao.findAll());
	}
	
	
}
