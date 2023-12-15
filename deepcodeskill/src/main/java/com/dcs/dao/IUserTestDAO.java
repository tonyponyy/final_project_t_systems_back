package com.dcs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dcs.dto.UserTest;

public interface IUserTestDAO extends JpaRepository<UserTest, Integer>{
	
	@Query(value = "SELECT ut.* FROM test_users ut " +
	           "JOIN tests t ON ut.id_test = t.id " +
	           "JOIN user_interviews ui ON ut.id_user = ui.id_user AND t.id_interview = ui.id_interview " +
	           "WHERE ut.id_user = ?1 AND ui.id_interview = ?2", nativeQuery = true)
	List<UserTest> findByUserIdAndInterviewId(Integer userId, Integer interviewId);
	
	@Query(value = "select * from test_users where id_user = ?1", nativeQuery = true)
	List<UserTest> findByUserId(Integer userId);
}

