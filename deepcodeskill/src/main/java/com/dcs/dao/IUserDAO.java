package com.dcs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcs.dto.User;

@Repository
public interface IUserDAO extends JpaRepository<User,Integer> {

	Optional<User> findByEmail(String email);
	
}
