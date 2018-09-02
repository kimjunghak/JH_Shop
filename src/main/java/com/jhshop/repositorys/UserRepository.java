package com.jhshop.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhshop.domains.User;

public interface UserRepository extends JpaRepository<User, String>{
	public User findByUserId(String userId); 
}
