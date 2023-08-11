package com.fpoly.Controller_User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Cart {

	@GetMapping("/cart")
	public String w() {
		return "cart";
	}
}
