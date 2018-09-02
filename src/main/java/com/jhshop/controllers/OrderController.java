package com.jhshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhshop.domains.Order;
import com.jhshop.domains.Product;
import com.jhshop.domains.User;
import com.jhshop.repositorys.OrderRepository;
import com.jhshop.repositorys.ProductRepository;
import com.jhshop.repositorys.UserRepository;

/**
 * @author JH
 * /order 페이지 Controller
 */

@Controller
@RequestMapping("/order")
public class OrderController {

	// DB 의 데이터를 주고받기 위한 선언부
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	// /checkout요청에서 productId, userID를 POST방식으로 받아 새로운 주문을 order DB에 추가 후 /order/orderlist.html로 매핑
	@PostMapping("/checkout")
	public String checkout(String productId, String userId) {
//		User loginUser = (User) session.getAttribute("login");
		// 인터넷에 HttpSession 객체를 통해서 현재 로그인 된 유저 정보를 가져올 수 있다는 방법을 찾았지만 잘 안되어 주석처리
		Product orderProduct = productRepository.findByProductId(productId);
		User user = userRepository.findByUserId(userId);
		
		Order saveOrder = new Order(null, user.getUserId(), orderProduct.getProductName());
		
		orderRepository.save(saveOrder);
		
		return "/order/orderlist";
	}
	
	// /orderlist 요청을 GET 방식으로 받아 Order 목록을 보여주는 역할
	@GetMapping("/orderlist")
	@ResponseBody
	public List<Order> orderList(String loginUserId) {
//		User loginUser = (User) session.getAttribute("login");
		List<Order> orderList = orderRepository.findByUserId(loginUserId);
		
		return orderList;
	}
}
