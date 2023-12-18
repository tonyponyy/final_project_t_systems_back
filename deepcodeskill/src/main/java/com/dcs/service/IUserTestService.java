package com.dcs.service;

import java.util.List;

import com.dcs.dto.UserTest;

public interface IUserTestService {
	
	public List<UserTest> listUserTest();
	
	public UserTest listById(Integer id);
	
	public UserTest updateUserTest(UserTest u);
	
	public UserTest addUserTest(UserTest u);
	
	public void deleteByIdUserTest(Integer id);
	
	public List<UserTest> findByUserIdAndInterviewId(Integer id_user,Integer id_interview);

	List<UserTest> findByUserId(Integer id_user);

	List<UserTest> findByInterviewId(Integer id_interview);


}
