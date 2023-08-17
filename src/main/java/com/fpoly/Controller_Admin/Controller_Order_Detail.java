package com.fpoly.Controller_Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.DAO.Order_DetailDAO;
import com.fpoly.Entity.Order_Detail;

@Controller
@PreAuthorize("hasRole('0')")
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
