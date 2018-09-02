package com.jhshop.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhshop.domains.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
	List<Product> findAll();
	Product findByProductId(String productId);
}
