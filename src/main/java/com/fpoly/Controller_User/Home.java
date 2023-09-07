package com.fpoly.Controller_User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

//	@Autowired
//	CartService cartService;
	
	@GetMapping("/home")
	public String home(Model model) {
		//model.addAttribute("countCart", cartService.getCount());
		return "index";
	}
	

}
