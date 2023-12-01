package com.dcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dcs.dto.InterviewSkill;

public interface IInterviewSkillDAO extends JpaRepository<InterviewSkill, Integer>{

	@Query(value = "select * from interview_skills where id_interview = ?1 and id_skill = ?2",nativeQuery=true)
	InterviewSkill findByInterviewIdAndSkillId(Integer id_interview, Integer id_skill);

}

