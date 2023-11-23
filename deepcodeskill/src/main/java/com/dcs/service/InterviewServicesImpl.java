package com.dcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.IInterviewDAO;
import com.dcs.dto.Interview;

@Service
public class InterviewServicesImpl implements IIterviewServices{

	@Autowired
	IInterviewDAO dao;
	
	@Override
	public List<Interview> listInterview() {
		return dao.findAll();
	}

	@Override
	public Interview listById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Interview updateInterview(Interview i) {
		return dao.save(i);
	}

	@Override
	public Interview addInterview(Interview i) {
		return dao.save(i);
	}

	@Override
	public void deleteByIdInterview(Integer id) {
		dao.deleteById(id);	
	}

}
