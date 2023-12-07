package com.dcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.IUserInterviewDAO;
import com.dcs.dto.User;
import com.dcs.dto.UserInterview;

@Service
public class IUserInterviewServiceImpl implements IUserInterviewService {

	@Autowired
	IUserInterviewDAO dao;

	@Override
	public List<UserInterview> listUserInterview() {
		return dao.findAll();
	}

	@Override
	public UserInterview listUserInterviewById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public UserInterview saveUserInterview(UserInterview ui) {
		return dao.save(ui);
	}

	@Override
	public UserInterview updateUserInterview(UserInterview ui) {
		return dao.save(ui);
	}

	@Override
	public void deleteByIdUserInterview(Integer id) {
		dao.deleteById(id);
	}
	
	@Override
	public List<UserInterview> findByUser(User u) {
		return dao.findByUser(u);
	}
	
	@Override
	public UserInterview findByUserIdAndInterviewId(Integer user_id,Integer interview_id) {
		return dao.findByUserIdAndInterviewId(user_id,interview_id);
	}
	
	

}
