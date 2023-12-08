package com.dcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.Interview;
import com.dcs.dto.InterviewSkill;
import com.dcs.dto.Skill;
import com.dcs.service.IInterviewServiceImpl;
import com.dcs.service.IInterviewSkillServiceImpl;
import com.dcs.service.ISkillServiceImpl;

@RestController
@RequestMapping("/interviews_skills")
public class InterviewSkillsController {
	
	@Autowired
	IInterviewSkillServiceImpl tSer;
	
	@Autowired
	IInterviewServiceImpl iSer;
	@Autowired
	ISkillServiceImpl sSer;
	
	/*ROLE RH
	  El usuario de RH añade skills a las entrevistas*/
	@PostMapping("/add_by_ids/{id_interview}/{id_skill}")
	public InterviewSkill newInterviewSkill(@PathVariable(name="id_interview") Integer id_interview,@PathVariable(name="id_skill") Integer id_skill) {
		Interview interview =iSer.listById(id_interview);
		Skill skill = sSer.listById(id_skill);
		InterviewSkill interview_skill = new InterviewSkill();
		interview_skill.setInterview(interview);
		interview_skill.setSkill(skill);
		return tSer.addInterviewSkill(interview_skill);
	}
	
	/*ROLE RH
	  El usuario de RH borra skills de las entrevistas*/
	@DeleteMapping("/delete_by_ids/{id_interview}/{id_skill}")
	public void deleteInterviewSkill(@PathVariable(name="id_interview") Integer id_interview,@PathVariable(name="id_skill") Integer id_skill) {
		Interview interview =iSer.listById(id_interview);
		Skill skill = sSer.listById(id_skill);
		InterviewSkill interview_skill = tSer.getInterviewSkillByInterviewAndSkill(id_interview, id_skill);
		tSer.deleteByIdInterviewSkill(interview_skill.getId());
	}

}
