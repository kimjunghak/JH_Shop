package com.jhshop.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhshop.domains.Product;

/*
 * DB와 데이터를 주고받을 수 있는 respository 인터페이스
 */

public interface ProductRepository extends JpaRepository<Product, String>{
	List<Product> findAll();
	Product findByProductId(String productId);
}
