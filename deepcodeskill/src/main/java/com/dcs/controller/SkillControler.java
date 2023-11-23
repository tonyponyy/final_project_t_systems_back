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

import com.dcs.dto.Skill;
import com.dcs.service.ISkillServiceImpl;

@RestController
@RequestMapping("/skills")
public class SkillControler {
	
	@Autowired
	ISkillServiceImpl sSer;
	
	@GetMapping("/all")
	public List<Skill> listSkill(){
		return sSer.listSkill();
	}
	
	@GetMapping("/{id}")
	public Skill listById(@PathVariable(name="id") Integer id) {
		return sSer.listById(id);
	}
	
	@PutMapping("/{id}")
	public Skill updateSkill(@PathVariable(name="id") Integer id, @RequestBody Skill s) {
		
		Skill s1 = sSer.listById(id);
		Skill s2 = new Skill();
		
		s1.setId(s.getId());
		s1.setDescription(s.getDescription());
		s1.setSkill_name(s.getSkill_name());
		
		s2 = sSer.updateSkill(s1);
		
		return s2;
	}
	
	@PostMapping("/add")
	public Skill addSkill(@RequestBody Skill s) {
		return sSer.addSkill(s);
	}
	
	@DeleteMapping("/{id}")
	public void deleteByIdInterview (@PathVariable(name="id") Integer id) {
		sSer.deleteByIdSkill(id);
	}

}
