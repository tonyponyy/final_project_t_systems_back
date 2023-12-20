package com.dcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.QualificateUserSkills;
import com.dcs.dto.QualificateUserTest;
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
	

    
	/*ROLE RH*/
	@PostMapping("/user_test/{id_test}/{id_user}")
	public ResponseEntity<UserTest> userDoTest(@PathVariable(name = "id_test") Integer id_test,@PathVariable(name="id_user") Integer id_user) {

	    User current_user = userServiceImpl.userById(id_user);
	    Test test = testServiceImpl.listTestById(id_test);
	    UserTest ut = new UserTest();
	    ut.setUser(current_user);
	    ut.setTest(test);
		return new ResponseEntity<> (uSer.addUserTest(ut), HttpStatus.OK);
	}
	
	@PostMapping("/qualificate/{id_usertest}")
	public ResponseEntity<UserTest> calificateUserTest(@PathVariable(name = "id_usertest") Integer id_usertest
			,@RequestBody QualificateUserTest data ) {
		UserTest user_test = uSer.listById(id_usertest);
		user_test.setCalification(data.getCalification());
		user_test.setDo_at(data.getDo_at());
		
		return new ResponseEntity<> (uSer.updateUserTest(user_test), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_user_test/{id_user_test}")
	public ResponseEntity<String> deleteUserTest(@PathVariable(name = "id_user_test") Integer id_usertest) {
		uSer.deleteByIdUserTest(id_usertest);
		return new ResponseEntity<> ("Test user deleted", HttpStatus.OK);
	}
	
	
}
