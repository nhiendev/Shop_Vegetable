package com.fpoly.Controller_User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fpoly.Entity.Users;
import com.fpoly.Service.LoginService;

@Controller
public class Login {

	@Autowired
	private LoginService service;

	@GetMapping("/login")
	public String login(Model model, @ModelAttribute("user") Users users, @ModelAttribute("userLogin") Users user) {

		return "SignIn_Up";
	}
	@PostMapping("/login/success")
	public String signIn(Model model, @ModelAttribute("userLogin") Users us) {
//		if (us.getUsername().equals("") || us.getPassword().equals("")) {
//			System.out.println("khong co gi");
//			return "redirect:/login";
//		}
//		System.out.println("add cookie");
		service.Login(us);
		return "redirect:/home";

	}

	@GetMapping("/logout")
	public String logout() {
		service.Logout();
		return "redirect:/login";
	}

	@PostMapping("/sign-up")
	public String signUp(Model model, @ModelAttribute("user") Users us) {

		us.setAdmin(1);
		service.save(us);

		return "redirect:/login";
	}

}
