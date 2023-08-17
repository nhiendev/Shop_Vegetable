package com.fpoly.Controller_Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.DAO.Order_DetailDAO;
import com.fpoly.DAO.ProductDAO;

@Controller
@PreAuthorize("hasRole('0')")
@RequestMapping("/admin")
public class Controller_Statistics {

	@Autowired
	ProductDAO dao;
	
	@Autowired
	Order_DetailDAO odDAO;
	
	@GetMapping("/bestseller")
	public String bestseller(Model model) {
		model.addAttribute("listProduct", dao.findAllBestSeler());
		return"Admin/tblBestseller";
	}
	
	@GetMapping("/inventory")
	public String inventory(Model model) {
		model.addAttribute("listInventory", dao.findAllBestInventory());
		return"Admin/tblInventory";
	}
	
	@GetMapping("/revenue-today")
	public String revenue(Model model) {
		model.addAttribute("revenueByDay", odDAO.getStatisticsByDay());
		model.addAttribute("totalRevenueByDay", odDAO.getStatisticsOrderAndTotalByDay());
		return"Admin/tblStatisticsByDay";
	}
}
