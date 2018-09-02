package com.jhshop.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhshop.domains.User;

@Controller
public class HomeController {
	
	
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/logged")
	public String loginUser(HttpSession session){
		User user = (User) session.getAttribute("login");
		return "/user/logged";
	}
}
