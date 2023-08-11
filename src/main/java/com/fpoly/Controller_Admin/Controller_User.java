package com.fpoly.Controller_Admin;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.DAO.UserDAO;
import com.fpoly.Entity.Users;
import com.fpoly.Service.UserService;

@Controller
@RequestMapping("/admin")
public class Controller_User {
	
	@Autowired
	UserService service;
	
	@Autowired
	UserDAO dao;
	
	@GetMapping("/user")
	public String view() {
		
		return "Admin/tblUser";
	}
	
	@GetMapping("/user/create")
	public String create(Model model) {
		model.addAttribute("user", new Users());	
		return "Admin/editUser";
	}
	
	@GetMapping("/user/{id}")
	public String edit(Model model,@PathVariable("id") Integer idU) {
		
		Users us = service.findById(idU);
		model.addAttribute("user", us);
		return "Admin/editUser";
	}
	
	@PostMapping("/user/save")		
	public String save(Model model,@ModelAttribute("user") Users users) {
		service.save(users);
		return "Admin/editUser";
	}
	
	@PostMapping("/user/delete/{id}")
	public String delete(Model model,@PathVariable("id") Integer id) {
		service.delete(id);
		return "redirect:/admin/user";
	}
}
