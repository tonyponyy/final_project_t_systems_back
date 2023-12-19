package com.dcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    /*ROLE USER
	  Asignar una skill a un usuario*/
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
    @PostMapping("/qualificate/{id_user}/{id_skill}")
	public UserSkill qualificate_user_skill(@PathVariable(name="id_user") Integer id_user,@PathVariable(name="id_skill") Integer id_skill
			,@RequestBody String comment,@RequestBody Float qualification) {
    	
		UserSkill user_skill = uSer.findByUserIdAndSkillId(id_user,id_skill);
		user_skill.setQualification(qualification);
		user_skill.setComment(comment);
		return uSer.addUserSkill(user_skill);
	}
    /*ROLE USER
	 Eliminar una skill de un usuario*/
    @DeleteMapping("/delete_by/{id_skill}")
	public void deleteInterviewSkill(@PathVariable(name="id_skill") Integer id_skill) {
    	org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    User current_user = iuuSer.findByEmail(authentication.getName());
    	
		Skill skill = sSer.listById(id_skill);
		UserSkill user_skill = uSer.findByUserIdAndSkillId(current_user.getId(), id_skill);
		uSer.deleteByIdUserSkill(user_skill.getId());
	}
}