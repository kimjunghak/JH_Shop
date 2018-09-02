package com.jhshop.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhshop.domains.User;

/*
 * DB와 데이터를 주고받을 수 있는 respository 인터페이스
 */

public interface UserRepository extends JpaRepository<User, String>{
	public User findByUserId(String userId); 
}
