package com.jhshop.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhshop.domains.User;
import com.jhshop.repositorys.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/signup")
	public String signupForm() {
		return "/user/signup";
	}
	
	@PostMapping("/signup")
	public String signup(User newUser) {
		userRepository.save(newUser);
		return "redirect:/";
	}
	
	@GetMapping("/signin")
	public String signinForm() {
		return "/user/signin";
	}
	
	@PostMapping("/signin")
	public String signin(User user, HttpSession session) {
		User oldUser = new User();
		
		if(userRepository.count() != 0) {
			oldUser = userRepository.findByUserId(user.getUserId());
			System.out.println("pass");
			if(oldUser.getUserId().equals(user.getUserId()) && oldUser.getPw().equals(user.getPw())) {
				session.setAttribute("login", user);		//로그인 계정 세션에 저장
				return "redirect:/logged";
			}
		}
		
		return "/user/signin";
	}
	
	@GetMapping("/signout")
	public String signout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/";
	}
}
