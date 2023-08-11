package com.fpoly.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.DAO.OrderDAO;
import com.fpoly.Entity.Order;

@CrossOrigin("*")
@RestController
public class API_Order {
	
	@Autowired
	OrderDAO dao;
	
	@GetMapping("/api/order")
	public ResponseEntity<List<Order>> getAll() {
		return ResponseEntity.ok(dao.findAll());
	}
	
	@GetMapping("/api/order/list")
	public ResponseEntity<List<Order>> getAlls() {
		return ResponseEntity.ok(dao.findByStatus(1));
	}

}
