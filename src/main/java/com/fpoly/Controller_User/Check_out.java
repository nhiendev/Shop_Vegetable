package com.fpoly.Controller_User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fpoly.Service.CheckoutService;

@Controller
public class Check_out {

	@Autowired
	CheckoutService checkoutService;
	
	@GetMapping("/checkout")
	public String viewCheckout(Model model) {
		if(checkoutService.getUser() == false) {
			return "redirect:/login";
		}
		model.addAttribute("user", checkoutService.findByUserOrder());
		;
		return "checkout";
	}
	
	@GetMapping("/checkout/pay")
	public String pay(Model model) {
		if(checkoutService.getUser() == false) {
			return "redirect:/login";
		}
		return "checkout";
	}
}
