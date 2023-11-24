package com.dcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.IUserTestDAO;
import com.dcs.dto.UserTest;

@Service
public class IUserTestServiceImpl implements IUserTestService{
	
	@Autowired
	IUserTestDAO dao;

	@Override
	public List<UserTest> listUserTest() {
		return dao.findAll();
	}

	@Override
	public UserTest listById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public UserTest updateUserTest(UserTest u) {
		return dao.save(u);
	}

	@Override
	public UserTest addUserTest(UserTest u) {
		return dao.save(u);
	}

	@Override
	public void deleteByIdUserTest(Integer id) {
		dao.deleteById(id);	
		
	}

}
