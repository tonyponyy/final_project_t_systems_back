package com.dcs.service;

import java.util.List;

import com.dcs.dto.UserTest;

public interface IUserTestService {
	
	public List<UserTest> listUserTest();
	
	public UserTest listById(Integer id);
	
	public UserTest updateUserTest(UserTest u);
	
	public UserTest addUserTest(UserTest u);
	
	public void deleteByIdUserTest(Integer id);

}
