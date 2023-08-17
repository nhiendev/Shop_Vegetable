package com.fpoly.Controller_User;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasAnyRole('0','1')")
public class NotFound {
	
	@GetMapping("/not-found")
	public String notFound() {
		return"404";
	}
}
