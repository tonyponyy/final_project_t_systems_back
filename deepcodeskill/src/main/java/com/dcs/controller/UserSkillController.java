package com.dcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.Interview;
import com.dcs.dto.InterviewSkill;
import com.dcs.dto.Skill;
import com.dcs.dto.User;
import com.dcs.dto.UserSkill;
import com.dcs.service.ISkillServiceImpl;
import com.dcs.service.IUserServiceImpl;
import com.dcs.service.IUserSkillServiceImpl;

@RestController
@RequestMapping("/userskills")
public class UserSkillController {
	
    @Autowired
    IUserSkillServiceImpl uSer;
    
    @Autowired
    ISkillServiceImpl sSer;
    
    @Autowired
	IUserServiceImpl iuuSer;
    
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
    
    @PostMapping("/add_by/{id_skill}")
	public UserSkill newInterviewSkill(@PathVariable(name="id_skill") Integer id_skill) {
	    org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    User current_user = iuuSer.findByEmail(authentication.getName());

		Skill skill = sSer.listById(id_skill);
		UserSkill user_skill = new UserSkill();
		user_skill.setUser(current_user);
		user_skill.setSkill(skill);
		return uSer.addUserSkill(user_skill);
	}
	
    @DeleteMapping("/delete_by/{id_skill}")
	public void deleteInterviewSkill(@PathVariable(name="id_skill") Integer id_skill) {
    	org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    User current_user = iuuSer.findByEmail(authentication.getName());
    	
		Skill skill = sSer.listById(id_skill);
		UserSkill user_skill = uSer.findByUserIdAndSkillId(current_user.getId(), id_skill);
		uSer.deleteByIdUserSkill(user_skill.getId());
	}
}