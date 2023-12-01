package com.dcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.IInterviewSkillDAO;
import com.dcs.dto.Interview;
import com.dcs.dto.InterviewSkill;
import com.dcs.dto.Skill;

@Service
public class IInterviewSkillServiceImpl implements IInterviewSkillService{
	
	@Autowired
	IInterviewSkillDAO dao;

	@Override
	public List<InterviewSkill> listInterviewSkill() {
		return dao.findAll();
	}

	@Override
	public InterviewSkill listById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public InterviewSkill updateInterviewSkill(InterviewSkill u) {
		return dao.save(u);
	}

	@Override
	public InterviewSkill addInterviewSkill(InterviewSkill u) {
		return dao.save(u);
	}

	@Override
	public void deleteByIdInterviewSkill(Integer id) {
		dao.deleteById(id);	
		
	}
	
	@Override
	public InterviewSkill findByInterviewIdAndSkillId(Integer id_interview,Integer id_skill) {
	     return dao.findByInterviewIdAndSkillId(id_interview,id_skill);
	}

	public InterviewSkill getInterviewSkillByInterviewAndSkill(int interview, int skill) {
		return dao.findByInterviewIdAndSkillId(interview, skill);
		
	}




}
