package com.fpoly.Controller_User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fpoly.Service.UserService;

@Controller
@PreAuthorize("isAuthenticated()")
public class OrderByUser {
	
	@Autowired
	UserService service;
	
	@GetMapping("/order-user")
	public String viewOrder() {
		return "OrderForUser";
	}
}
