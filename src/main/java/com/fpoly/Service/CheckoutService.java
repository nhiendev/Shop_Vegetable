package com.fpoly.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.Entity.Users;
@Service
public class CheckoutService {

	@Autowired
	CookieService cookieService;

	@Autowired
	UserService userService;
	
	public boolean getUser() {
		String usName = cookieService.getValue("uName");
		if(usName.equals("")) {
			return false;
		}
		
		return true;
	}

	public Users findByUserOrder() {
		
		return userService.findByUsername(cookieService.getValue("uName"));
	}
	
	
}
