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
	
	@Autowired
	ITestServiceImpl testServiceImpl;
    
	/*ROLE RH
	  Añadir nota un test*/
	@PostMapping("/user_test/{id_test}/{id_user}")
	public ResponseEntity<UserTest> userDoTest(@PathVariable(name = "id_test") Integer id_test,@PathVariable(name="id_user") Integer id_user) {

	    User current_user = userServiceImpl.userById(id_user);
	    Test test = testServiceImpl.listTestById(id_test);
	    
	    UserTest ut = new UserTest();
	    ut.setUser(current_user);
	    ut.setTest(test);
	    
	    System.out.println(ut);
	       
		return new ResponseEntity<> (uSer.addUserTest(ut), HttpStatus.OK);
	}
}
