package com.fpoly.Controller_User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.Service.ProductService;

@Controller
public class Product_Detail {

	@Autowired
	ProductService service;

	@GetMapping("/404")
	public String view() {
		return "404";
	}

	@GetMapping("/product-detail")
	public String detai(Model model, @RequestParam(value = "id", defaultValue = "") Integer idP) {

		if (idP == null) {
			return "404";
		} else {
			com.fpoly.Entity.Product pr = service.findById(idP);
			model.addAttribute("product", pr);
			return "product-single";
		}

	}
}
