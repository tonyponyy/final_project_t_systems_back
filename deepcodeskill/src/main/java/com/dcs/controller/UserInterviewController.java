package com.dcs.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.CommentDTO;
import com.dcs.dto.Interview;
import com.dcs.dto.User;
import com.dcs.dto.UserInterview;
import com.dcs.dto.UserTest;
import com.dcs.service.IInterviewServiceImpl;
import com.dcs.service.IUserInterviewServiceImpl;
import com.dcs.service.IUserServiceImpl;
import com.dcs.service.IUserTestServiceImpl;

@RestController
@RequestMapping("/userinterviews")
public class UserInterviewController {
	
	@Autowired
	IUserInterviewServiceImpl uiSer;
	
	@Autowired
	IUserTestServiceImpl utser;
	
	@Autowired
	IInterviewServiceImpl iSer;
	
	@Autowired
	private IUserServiceImpl userServiceImpl;
	
	/*ROLE RH
	  Añadir un nuevo skill*/
	@PostMapping("/user_join_interview/{id_interview}")
	public ResponseEntity<UserInterview> addUserToInterview(@PathVariable(name="id_interview") Integer id_interview) {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
	    System.out.println("GET NAME"+authentication.getName());
	    User current_user = userServiceImpl.findByEmail(authentication.getName());
		Interview interview =iSer.listById(id_interview);
		
		UserInterview u1 = new UserInterview();
		u1.setUser(current_user);
		u1.setInterview(interview);
		u1.setState(1);
		u1.setJoined_at(new Date());
		
		return new ResponseEntity<>(uiSer.saveUserInterview(u1), HttpStatus.OK);
	}
	
	@PutMapping("/changeState/{id_interview}/{state}")
	public ResponseEntity<UserInterview> changeState(@PathVariable(name="id_interview") Integer id_interview,@PathVariable(name="state") Integer state) {
		UserInterview u1 = uiSer.listUserInterviewById(id_interview);
		UserInterview u2 = new UserInterview();
		
		if (state < 5) {
			u1.setState(state);
		}
		u2.setId(u1.getId());
		u2.setInternal_comment(u1.getInternal_comment());
		u2.setInterview(u1.getInterview());
		u2.setJoined_at(u1.getJoined_at());
		u2.setStamp(u1.getStamp());
		u2.setState(u1.getState());
		u2.setUser(u1.getUser());
		
		return new ResponseEntity<>(uiSer.updateUserInterview(u2), HttpStatus.OK);
	}
	
	@PutMapping("/changeComment/{id_interview}")
	public ResponseEntity<UserInterview> changeComment(@PathVariable(name="id_interview") Integer id_interview,@RequestBody CommentDTO comment) {
		UserInterview u1 = uiSer.listUserInterviewById(id_interview);
		UserInterview u2 = new UserInterview();
		
		if (comment.getComment() != "") {
			u1.setInternal_comment(comment.getComment());
		}
		u2.setId(u1.getId());
		u2.setInternal_comment(u1.getInternal_comment());
		u2.setInterview(u1.getInterview());
		u2.setJoined_at(u1.getJoined_at());
		u2.setStamp(u1.getStamp());
		u2.setState(u1.getState());
		u2.setUser(u1.getUser());
		
		return new ResponseEntity<>(uiSer.updateUserInterview(u2), HttpStatus.OK);
	}
	
	@GetMapping("/user_interviews")
		public ResponseEntity<Map<String, Object>> userListInterviews() {	
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
	    User current_user = userServiceImpl.findByEmail(authentication.getName());
	    List<UserInterview> userInterviews = uiSer.findByUser(current_user);
	    List<UserTest> userTest = utser.findByUserId(current_user.getId());
	    Map<String, Object> response = new HashMap<>();
	      response.put("interviews", userInterviews);
	      response.put("user_test", userTest);
	    
	      return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
