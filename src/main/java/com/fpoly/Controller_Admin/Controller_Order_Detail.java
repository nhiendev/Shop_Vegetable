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

import com.fpoly.DAO.OrderDAO;
import com.fpoly.DAO.Order_DetailDAO;
import com.fpoly.DAO.UserDAO;
import com.fpoly.Entity.Order;
import com.fpoly.Entity.Order_Detail;
import com.fpoly.Entity.Users;
import com.fpoly.Service.UserService;

@Controller
@RequestMapping("/admin")
public class Controller_Order_Detail {

	@Autowired
	Order_DetailDAO dao;



	@GetMapping("/order-detail/{id}")
	public String edit(Model model, @PathVariable("id") Integer idU) {

		List<Order_Detail> od = dao.getAllOd(idU);
		model.addAttribute("od", od);
		return "Admin/tblOrder_Dtail";
	}




}
