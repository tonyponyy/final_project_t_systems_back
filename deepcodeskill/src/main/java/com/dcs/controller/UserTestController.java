package com.dcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.Test;
import com.dcs.dto.User;
import com.dcs.dto.UserTest;
import com.dcs.service.ITestServiceImpl;
import com.dcs.service.IUserServiceImpl;
import com.dcs.service.IUserTestServiceImpl;

@RestController
@RequestMapping("/usertests")
public class UserTestController {
	
	@Autowired
	IUserTestServiceImpl uSer;
    
	@Autowired
	IUserServiceImpl userServiceImpl;
	
	ITestServiceImpl testServiceImpl;
    
	/*ROLE RH
	  Añadir nota un test*/
	@PostMapping("/user_test/{id_test}")
	public ResponseEntity<UserTest> userDoTest(@PathVariable(name = "id_test") Integer id, @RequestBody UserTest usertest) {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
	    System.out.println("GET NAME"+authentication.getName());
	    User current_user = userServiceImpl.findByEmail(authentication.getName());
	    Test test = testServiceImpl.listTestById(id);
	    
	    UserTest ut = new UserTest();
	    ut.setUser(current_user);
	    ut.setTest(test);
	    ut.setCalification(usertest.getCalification());
	    ut.setDo_at(usertest.getDo_at());
	        
		return new ResponseEntity<> (uSer.addUserTest(ut), HttpStatus.OK);
	}
}
