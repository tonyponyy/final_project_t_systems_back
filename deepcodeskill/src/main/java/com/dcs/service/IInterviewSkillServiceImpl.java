package com.dcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.IInterviewSkillDAO;
import com.dcs.dto.InterviewSkill;

@Service
public class IInterviewSkillServiceImpl implements IInterviewSkillService{
	
	@Autowired
	IInterviewSkillDAO dao;

	@Override
	public InterviewSkill addInterviewSkill(InterviewSkill u) {
		return dao.save(u);
	}

	@Override
	public void deleteByIdInterviewSkill(Integer id) {
		dao.deleteById(id);	
		
	}

	public InterviewSkill getInterviewSkillByInterviewAndSkill(int interview, int skill) {
		return dao.findByInterviewIdAndSkillId(interview, skill);
	
	}

}
