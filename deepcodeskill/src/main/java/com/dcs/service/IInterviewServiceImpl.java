package com.dcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dcs.dao.IInterviewDAO;
import com.dcs.dto.Interview;
import com.dcs.dto.InterviewBasic;

@Service
public class IInterviewServiceImpl implements IIterviewService{

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
	
	 @Override
	 public Page<Interview> getPaginatedInterviewBasic(Pageable pageable) {
	     return dao.findAll(pageable);
	 }
	 public Page<Interview> getPaginatedInterviewBasicTitle(String name, int page, int size) {
			PageRequest pageRequest = PageRequest.of(page, size);
			return dao.findByTitle(name, pageRequest);
			
		}
	 
}
