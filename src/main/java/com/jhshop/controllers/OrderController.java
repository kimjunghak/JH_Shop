package com.jhshop.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

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

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/checkout")
	public String checkout(String productId, String userId) {
//		User loginUser = (User) session.getAttribute("login");
		Product orderProduct = productRepository.findByProductId(productId);
		User user = userRepository.findByUserId(userId);
		
		Order saveOrder = new Order(null, user, orderProduct);
		
		orderRepository.save(saveOrder);
		
		return "/order/orderlist";
	}
	
	@GetMapping("/orderlist")
	@ResponseBody
	public List<Order> orderList(String loginUserId) {
//		User loginUser = (User) session.getAttribute("login");
		User loginUser = userRepository.findByUserId(loginUserId);
		List<Order> orderList = orderRepository.findByUser(loginUser);
		
		return orderList;
	}
}
