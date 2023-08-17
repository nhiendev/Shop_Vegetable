package com.fpoly.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.DAO.OrderDAO;
import com.fpoly.DAO.Order_DetailDAO;
import com.fpoly.Entity.Order;
import com.fpoly.Entity.Order_Detail;

@CrossOrigin("*")
@RestController
public class API_OrderByUser {

	@Autowired
	Order_DetailDAO dao;
	
	@Autowired
	OrderDAO Odao;
	
	@GetMapping("/api/order/user/{username}")
	public ResponseEntity<List<Order_Detail>> getAll(@PathVariable("username") String username) {
		if(dao.getOrderDetailByUser(username).size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dao.getOrderDetailByUser(username));
	}
	
	@GetMapping("/api/order/{id}")
	public ResponseEntity<Order> getAll(@PathVariable("id") Integer id) {
		if(!Odao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(Odao.findById(id).get());
	}
	
	@DeleteMapping(value = "/api/order/user/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		if (!Odao.existsById(id)) { // kiểm tra đã có trong SQL chưa
			return ResponseEntity.notFound().build();
		}else {
			Odao.deleteById(id);
		}
		
		return ResponseEntity.ok().build();
	}
	
}
