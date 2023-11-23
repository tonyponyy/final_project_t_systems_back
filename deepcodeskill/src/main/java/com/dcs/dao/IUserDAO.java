package com.dcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcs.dto.User;




public interface IUserDAO extends JpaRepository<User,Integer> {



	
}
