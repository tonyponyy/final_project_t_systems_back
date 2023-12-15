package com.dcs.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dcs.dto.Interview;
import com.dcs.dto.User;
import com.dcs.dto.UserInterview;

public interface IUserInterviewService {

	public List<UserInterview> listUserInterview();
	
	public UserInterview listUserInterviewById(Integer id);
	
	public UserInterview saveUserInterview(UserInterview ui);
	
	public UserInterview updateUserInterview(UserInterview ui);
	
	public void deleteByIdUserInterview(Integer id);
	
	public List<UserInterview> findByUser(User u);

	public UserInterview findByUserIdAndInterviewId(Integer user_id, Integer interview_id);
	
	//metodo para la paginacion
	Page<UserInterview> getPaginatedUserInterview(Pageable pageable);
	}
