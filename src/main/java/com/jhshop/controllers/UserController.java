package com.jhshop.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhshop.domains.User;
import com.jhshop.repositorys.UserRepository;

/**
 * @author JH
 * /user 페이지 Controller
 */

@Controller
@RequestMapping("/user")
public class UserController {

	// user DB와 데이터 주고받기 위함
	@Autowired
	private UserRepository userRepository;
	
	// signup 요청을 GET방식으로 받아 signup form이 존재하는 페이지로 매핑
	@GetMapping("/signup")
	public String signupForm() {
		return "/user/signup";
	}
	
	// signup 요청을 POST 방식으로 signup form에 작성한 값들을 받아와 user DB에 저장
	@PostMapping("/signup")
	public String signup(User newUser) {
		userRepository.save(newUser);
		return "redirect:/";
	}
	
	// signin 요청을 GET방식으로 받아 signin form이 존재하는 페이지로 매핑
	@GetMapping("/signin")
	public String signinForm() {
		return "/user/signin";
	}
	
	// signin 요청을 POST 방식으로 signin form에 작성한 값들을 받아와 user DB에 등록된 데이터들과 비교하여
	// 아이디 비밀번호 비교 후 성공하면 로그인 완료 패이지 매핑
	// 실패하면 signin 페이지 redirect
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
	
	//login 한 유저 정보 노출페이지
	@GetMapping("/logged")
	@ResponseBody
	public String loginUser(String userId){
//		User user = (User) session.getAttribute("login");
		User loginUser = userRepository.findByUserId(userId);
		return loginUser.toString();
	}
	
	// signout 을 요청받아 home 페이지로 이동
	@GetMapping("/signout")
	public String signout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/";
	}
}
