package com.jhshop.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhshop.domains.Order;
import com.jhshop.domains.User;


public interface OrderRepository extends JpaRepository<Order, Long>{
	Order findByOrderId(Long orderId);
	List<Order> findByUser(User user);
}
