package com.dcs.service;

import java.util.List;

import com.dcs.dto.InterviewSkill;

public interface IInterviewSkillService {

	public List<InterviewSkill> listInterviewSkill();
	
	public InterviewSkill updateInterviewSkill(InterviewSkill ui);
	
	public void deleteByIdInterviewSkill(Integer id);

	public InterviewSkill listById(Integer id);

	public InterviewSkill addInterviewSkill(InterviewSkill u);

	public InterviewSkill findByInterviewIdAndSkillId(Integer id_interview, Integer id_skill);
}
