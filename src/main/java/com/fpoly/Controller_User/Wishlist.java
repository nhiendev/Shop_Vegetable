package com.fpoly.Controller_User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Wishlist {
	
	
	@GetMapping("/wishlist")
	public String wishlist(Model model) {
		
		return "wishlist";
	}
}
