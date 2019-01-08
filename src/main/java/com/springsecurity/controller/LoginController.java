package com.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		return "fancy-login";
		//return "plain-login";
	}
	//add request mapping for /systems
	@GetMapping("/access-denied")
	public String showAccessDenied() {
			return "access-denied";
	}
}
