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

import com.dcs.dto.UserSkill;
import com.dcs.service.IUserSkillServiceImpl;

@RestController
@RequestMapping("/userskills")
public class UserSkillController {
	
    @Autowired
    IUserSkillServiceImpl uSer;
    
    @GetMapping("/all")
    public List<UserSkill> listUserTest(){
        return uSer.listUserSkill();
    }
    
    @GetMapping("/{id}")
    public UserSkill listById(@PathVariable(name="id") Integer id) {
        return uSer.listById(id);
    }
    
    @PutMapping("/{id}")
    public UserSkill updateUserSkill(@PathVariable(name="id") Integer id, @RequestBody UserSkill us) {
        
        UserSkill u1 = uSer.listById(id);
        UserSkill u2 = new UserSkill();
        
        u1.setId(us.getId());
        u1.setUser(us.getUser());
        u1.setSkill(us.getSkill());
        
        u2 = uSer.updateUserSkill(u1);
        
        return u2;
    }
    
    @PostMapping("/add")
    public UserSkill addUserSkill(@RequestBody UserSkill us) {
        return uSer.addUserSkill(us);
    }
    
    @DeleteMapping("/{id}")
    public void deleteByIdUserSkill (@PathVariable(name="id") Integer id) {
        uSer.deleteByIdUserSkill(id);
    }
}