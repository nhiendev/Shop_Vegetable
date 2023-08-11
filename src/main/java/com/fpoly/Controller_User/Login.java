package com.fpoly.Controller_User;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fpoly.Entity.Users;
import com.fpoly.HandleService.HashPass;
import com.fpoly.Service.CookieService;
import com.fpoly.Service.LoginService;

@Controller
public class Login {

	@Autowired
	private LoginService service;

	

	@GetMapping("/login")
	public String login(Model model, @ModelAttribute("user") Users users, @ModelAttribute("userLogin") Users user) {
//		model.addAttribute("user", new Users());
//		model.addAttribute("userLogin", new Users());
		return "SignIn_Up";
	}

	@PostMapping("/login")
	public String signIn(Model model, @ModelAttribute("userLogin") Users us) {

		if (us.getUsername().equals("") || us.getPassword().equals("")) {
			return "redirect:/login";
		} else {

			if (service.Login(us) == true)
				return "redirect:/home";
			else
				return "redirect:/login";
		}

//		Users u = service.findByUsers(us.getUsername());
//		if(u != null) {
//			Boolean checkPass = hashPass.verify(us.getPassword(), u.getPassword());	
//			if(u.getUsername().equals(us.getUsername()) && checkPass == true) {
//			//	sessionService.set("user", u);
//				cookie.add("uName", u.getUsername(), 10);
//				cookie.add("uPass", u.getUsername(), 10);
//				
//			}
//		}

	}

	@PostMapping("/sign-up")
	public String signUp(Model model, @ModelAttribute("user") Users us) {

			us.setAdmin(1);
			service.save(us);

		return "redirect:/login";
	}

}
