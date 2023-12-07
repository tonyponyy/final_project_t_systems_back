package com.dcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dcs.dao.ISkillDAO;
import com.dcs.dto.Interview;
import com.dcs.dto.Skill;

@Service
public class ISkillServiceImpl implements ISkillService{

	@Autowired
	ISkillDAO dao;

	@Override
	public List<Skill> listSkill() {
		return dao.findAll();
	}

	@Override
	public Skill listById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Skill updateSkill(Skill s) {
		return dao.save(s);
	}

	@Override
	public Skill addSkill(Skill s) {
		return dao.save(s);
	}

	@Override
	public void deleteByIdSkill(Integer id) {
		dao.deleteById(id);	
		
	}

	@Override
	public Page<Skill> getPaginatedSkills(Pageable pageable) {
		return dao.findAll(pageable);
	}
	

}
