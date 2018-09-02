package com.jhshop.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhshop.domains.Order;
import com.jhshop.domains.User;

/*
 * DB와 데이터를 주고받을 수 있는 respository 인터페이스
 */
public interface OrderRepository extends JpaRepository<Order, Long>{
	Order findByOrderId(Long orderId);
	List<Order> findByUser(User user);
}
