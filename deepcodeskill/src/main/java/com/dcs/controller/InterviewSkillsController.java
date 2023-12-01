package com.dcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	
	@PostMapping("/add_by_ids/{id_interview}/{id_skill}")
	public InterviewSkill newInterviewSkill(@PathVariable(name="id_interview") Integer id_interview,@PathVariable(name="id_skill") Integer id_skill) {
		Interview interview =iSer.listById(id_interview);
		Skill skill = sSer.listById(id_skill);
		InterviewSkill interview_skill = new InterviewSkill();
		interview_skill.setInterview(interview);
		interview_skill.setSkill(skill);
		return tSer.addInterviewSkill(interview_skill);
	}
	
	@DeleteMapping("/delete_by_ids/{id_interview}/{id_skill}")
	public void deleteInterviewSkill(@PathVariable(name="id_interview") Integer id_interview,@PathVariable(name="id_skill") Integer id_skill) {
		Interview interview =iSer.listById(id_interview);
		Skill skill = sSer.listById(id_skill);
		InterviewSkill interview_skill = tSer.getInterviewSkillByInterviewAndSkill(id_interview, id_skill);
		tSer.deleteByIdInterviewSkill(interview_skill.getId());
	}
	
	
	@GetMapping("/all")
	public List<InterviewSkill> listInterviewSkill(){
		return tSer.listInterviewSkill();
	}
	
	@GetMapping("/{id}")
	public InterviewSkill listInterviewSkillById(@PathVariable(name="id") Integer id) {
		return tSer.listById(id);
	}
	
	@PostMapping("/add")
	public InterviewSkill newInterviewSkill(@RequestBody InterviewSkill t) {
		return tSer.addInterviewSkill(t);
	}
		
	@PutMapping("/{id}")
	public InterviewSkill updateInterviewSkill(@PathVariable(name="id") Integer id, @RequestBody Interview interview, Skill skill) {
		InterviewSkill t1 = tSer.listById(id);
		InterviewSkill t2 = new InterviewSkill();
		t1.setId(t1.getId());
		t1.setInterview(interview);
		t1.setSkill(skill);
		t2 = tSer.updateInterviewSkill(t1);
		return t2;
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(name="id") Integer id) {
		tSer.deleteByIdInterviewSkill(id);
	}

}
