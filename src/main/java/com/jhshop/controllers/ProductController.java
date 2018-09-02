package com.jhshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JH
 * Product 페이지의 Controller
 */

@Controller
@RequestMapping("/product")
public class ProductController {
	
	// /productlist 요청을 받으면 /product/productlist.html로 매핑해주는 역할
	@GetMapping("/productlist")
	public String productList(){
		return "/product/productlist";
	}
	
}
