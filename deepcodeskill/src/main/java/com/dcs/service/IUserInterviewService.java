package com.dcs.service;

import java.util.List;

import com.dcs.dto.UserInterview;

public interface IUserInterviewService {

	public List<UserInterview> listUserInterview();
	
	public UserInterview listUserInterviewById(Integer id);
	
	public UserInterview saveUserInterview(UserInterview ui);
	
	public UserInterview updateUserInterview(UserInterview ui);
	
	public void deleteByIdUserInterview(Integer id);
}
