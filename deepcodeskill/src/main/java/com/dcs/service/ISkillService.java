package com.dcs.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dcs.dto.Skill;

public interface ISkillService {
	
	public List<Skill> listSkill();
	
	public Skill listById(Integer id);
	
	public Skill updateSkill(Skill s);
	
	public Skill addSkill(Skill s);
	
	public void deleteByIdSkill(Integer id);
	
	Page<Skill> getPaginatedSkills(Pageable pageable);

}
