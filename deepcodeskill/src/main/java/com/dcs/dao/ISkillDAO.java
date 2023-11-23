package com.dcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcs.dto.Skill;

public interface ISkillDAO extends JpaRepository<Skill, Integer>{

}
