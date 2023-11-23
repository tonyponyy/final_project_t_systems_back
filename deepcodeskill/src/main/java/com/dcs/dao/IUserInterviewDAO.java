package com.dcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcs.dto.UserInterview;

public interface IUserInterviewDAO extends JpaRepository<UserInterview, Integer>{

}
