package com.lsy.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lsy.board.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);
	public boolean existsByUsername(String username);
	
}
