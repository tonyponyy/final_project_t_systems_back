package com.dcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.IUserSkillDAO;
import com.dcs.dto.UserSkill;

@Service
public class IUserSkillServiceImpl implements IUserSkillService{
    
    @Autowired
    IUserSkillDAO dao;

    @Override
    public List<UserSkill> listUserSkill() {
        return dao.findAll();
    }

    @Override
    public UserSkill listById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public UserSkill updateUserSkill(UserSkill us) {
        return dao.save(us);
    }

    @Override
    public UserSkill addUserSkill(UserSkill us) {
        return dao.save(us);
    }

    @Override
    public void deleteByIdUserSkill(Integer id) {
        dao.deleteById(id);    
    }

    @Override
    public List<UserSkill> findByUserIdAndSkillId(Integer id_user, Integer id_skill) {
        return dao.findByUserIdAndSkillId(id_user,id_skill);
    }

}