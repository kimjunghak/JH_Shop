package com.jhshop.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JH
 * 홈 화면을 제어해줄 Controller
 */

@Controller
public class HomeController {
	
	
	// Home 페이지 index.html 매핑
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
}
