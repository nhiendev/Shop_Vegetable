package com.fpoly.Controller_Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpoly.DAO.OrderDAO;
import com.fpoly.DAO.UserDAO;
import com.fpoly.Entity.Order;
import com.fpoly.Entity.Users;
import com.fpoly.Service.UserService;

@Controller
@RequestMapping("/admin")
public class Controller_Order {

	@Autowired
	UserService service;

	@Autowired
	OrderDAO dao;

	@GetMapping("/order")
	public String view(Model model) {
		
		model.addAttribute("orders", dao.findByStatus(0));
		return "Admin/tblOrder";
	}
	@GetMapping("/order/deliver")
	public String deliver(Model model) {
		List<Order> list = dao.findByStatus(1);
		model.addAttribute("orderDeliver", dao.findByStatus(1));
		return "Admin/tblOrder";
	}

	@GetMapping("/order/{id}")
	public String edit(Model model, @PathVariable("id") Integer idU) {

		Users us = service.findById(idU);
		model.addAttribute("user", us);
		return "Admin/editUser";
	}

	@GetMapping("/order/save/{id}")
	public String save(Model model, @PathVariable("id") Integer idU) {
		Order order = dao.getReferenceById(idU);
		order.setStatus(1);
		dao.save(order);
		return "redirect:/admin/order";
	}

	@PostMapping("/order/delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id) {
		service.delete(id);
		return "redirect:/admin/user";
	}
}
