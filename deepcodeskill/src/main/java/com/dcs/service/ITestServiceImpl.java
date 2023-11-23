package com.dcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.ITestDAO;
import com.dcs.dto.Test;

@Service
public class ITestServiceImpl implements ITestService{
	
	@Autowired
	ITestDAO dao;

	@Override
	public List<Test> listTest() {
		return dao.findAll();
	}

	@Override
	public Test listTestById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Test saveTest(Test t) {
		return dao.save(t);
	}

	@Override
	public Test updateTest(Test t) {
		return dao.save(t);
	}

	@Override
	public void deleteByIdTest(Integer id) {
		dao.deleteById(id);
	}
	
	

}
