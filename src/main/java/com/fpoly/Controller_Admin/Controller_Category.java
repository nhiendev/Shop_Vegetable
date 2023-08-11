package com.fpoly.Controller_Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.DAO.CategoryDAO;

@Controller
@RequestMapping("/admin")
public class Controller_Category {
	
	@Autowired
	CategoryDAO dao;
	
	@GetMapping("/category")
	public String view() {
		return "Admin/tblCategory";
	}
	
}
