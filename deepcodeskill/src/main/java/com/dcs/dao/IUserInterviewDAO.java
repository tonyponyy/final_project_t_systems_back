package com.dcs.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dcs.dto.Interview;
import com.dcs.dto.User;
import com.dcs.dto.UserInterview;


public interface IUserInterviewDAO extends JpaRepository<UserInterview, Integer>{

	@Query(value = "select * from user_interviews where id_user = ?1 and id_interview = ?2",nativeQuery=true)
	UserInterview findByUserIdAndInterviewId(Integer userId, Integer interviewId);
	
	List<UserInterview> findByUser(User u);
	
	
}
