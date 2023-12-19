package com.dcs.service;

import java.util.List;

import com.dcs.dto.UserSkill;

public interface IUserSkillService {

    public List<UserSkill> listUserSkill();
    
    public UserSkill listById(Integer id);
    
    public UserSkill updateUserSkill(UserSkill us);
    
    public UserSkill addUserSkill(UserSkill us);
    
    public void deleteByIdUserSkill(Integer id);
    
    public UserSkill findByUserIdAndSkillId(Integer id_user,Integer id_skill);
    
    public List<UserSkill> findByInterviewId(Integer id);
}