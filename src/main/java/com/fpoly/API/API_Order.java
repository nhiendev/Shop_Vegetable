package com.fpoly.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fpoly.DAO.OrderDAO;
import com.fpoly.Entity.Order;
import com.fpoly.Service.OrderService;

@CrossOrigin("*")
@RestController
public class API_Order {
	
	@Autowired
	OrderDAO dao;
	
	@Autowired
	OrderService orderService;
	@GetMapping("/api/order")
	public ResponseEntity<List<Order>> getAll() {
		return ResponseEntity.ok(dao.findAll());
	}
	
	@GetMapping("/api/order/list")
	public ResponseEntity<List<Order>> getAlls() {
		return ResponseEntity.ok(dao.findByStatus(1));
	}

	@PostMapping("/api/orders")
	public Order create(@RequestBody JsonNode nodeData) {
		
		return orderService.create(nodeData);
	}
	
}
