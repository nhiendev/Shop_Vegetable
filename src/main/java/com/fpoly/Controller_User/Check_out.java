package com.fpoly.Controller_User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fpoly.Service.CheckoutService;

@Controller
@PreAuthorize("isAuthenticated()")
public class Check_out {

	@Autowired
	CheckoutService checkoutService;
	
	@GetMapping("/checkout")
	public String viewCheckout(Model model) {
		if(checkoutService.getUser() == false) {
			return "redirect:/login";
		}
		model.addAttribute("user", checkoutService.findByUserOrder());
		return "checkout";
	}
	
	@PostMapping("/checkout/pay")
	public String pay(Model model) {
			
		return "redirect:/home";
	}
	
	@GetMapping("/checkout/pay-cart")
	public String pay_cart(Model model) {
		if(checkoutService.getUser() == false) {
			return "redirect:/login";
		}
		return "redirect:/home";
	}
}
