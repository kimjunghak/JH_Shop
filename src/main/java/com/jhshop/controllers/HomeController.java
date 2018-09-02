package com.jhshop.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhshop.domains.User;

/**
 * @author JH
 * 홈 화면을 제어해줄 Controller
 */

@Controller
public class HomeController {
	
	
	// / 와 /logged 요청을 받으면 각각 index.html, /user/logged.html로 매핑해주는 역할
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
