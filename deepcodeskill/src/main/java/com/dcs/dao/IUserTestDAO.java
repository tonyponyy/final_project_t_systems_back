package com.dcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcs.dto.UserTest;

public interface IUserTestDAO extends JpaRepository<UserTest, Integer>{

}
