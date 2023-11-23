package com.dcs.service;

import java.util.List;

import com.dcs.dto.Test;

public interface ITestService {
	
	public List<Test> listTest();
	
	public Test listTestById(Integer id);
	
	public Test saveTest(Test t);
	
	public Test updateTest(Test t);
	
	public void deleteByIdTest(Integer id);
}
