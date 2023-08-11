package com.fpoly.Controller_User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fpoly.Service.CartService;

@Controller
public class Home {

	@Autowired
	CartService cartService;
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("countCart", cartService.getCount());
		return "index";
	}
	

}
