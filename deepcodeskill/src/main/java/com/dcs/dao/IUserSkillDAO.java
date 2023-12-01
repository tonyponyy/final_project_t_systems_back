package com.dcs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dcs.dto.UserSkill;

public interface IUserSkillDAO extends JpaRepository<UserSkill, Integer> {
    
    @Query(value = "SELECT * FROM users_skill WHERE id_user = ?1 AND id_skill = ?2", nativeQuery = true)
    List<UserSkill> findByUserIdAndSkillId(Integer userId, Integer skillId);
}