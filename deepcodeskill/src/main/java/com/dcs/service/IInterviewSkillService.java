package com.dcs.service;

import com.dcs.dto.InterviewSkill;

public interface IInterviewSkillService {

	public void deleteByIdInterviewSkill(Integer id);

	public InterviewSkill addInterviewSkill(InterviewSkill u);

	public InterviewSkill getInterviewSkillByInterviewAndSkill(int interview, int skill);
}
