package com.dcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dcs.dto.UserSkill;

public interface IUserSkillDAO extends JpaRepository<UserSkill, Integer> {
    
    @Query(value = "SELECT * FROM user_skills WHERE id_user = ?1 AND id_skill = ?2", nativeQuery = true)
    UserSkill findByUserIdAndSkillId(Integer userId, Integer skillId);
    
    
}