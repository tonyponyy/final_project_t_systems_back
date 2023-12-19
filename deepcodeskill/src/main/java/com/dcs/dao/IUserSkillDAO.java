package com.dcs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dcs.dto.UserSkill;

public interface IUserSkillDAO extends JpaRepository<UserSkill, Integer> {
    
    @Query(value = "SELECT * FROM user_skills WHERE id_user = ?1 AND id_skill = ?2", nativeQuery = true)
    UserSkill findByUserIdAndSkillId(Integer userId, Integer skillId);
    
    @Query(value = "SELECT * FROM user_skills WHERE id_user in (select id_user from user_interviews where id_interview = ?1)", nativeQuery = true)
	List<UserSkill> findByInterviewId(Integer id);
    
}