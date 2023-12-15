package com.dcs.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.Interview;
import com.dcs.dto.User;
import com.dcs.dto.UserInterview;
import com.dcs.service.IInterviewServiceImpl;
import com.dcs.service.IUserInterviewServiceImpl;
import com.dcs.service.IUserServiceImpl;

@RestController
@RequestMapping("/userinterviews")
public class UserInterviewController {
	
	@Autowired
	IUserInterviewServiceImpl uiSer;
	
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
	
	@GetMapping("/user_interviews")
		public ResponseEntity<Map<String, Object>> userListInterviews(@RequestParam(defaultValue = "0") int page,
				@RequestParam(defaultValue = "5") int size) {	
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
	    System.out.println("GET NAME"+authentication.getName());
	    
		Page<UserInterview> userInterviewPage = uiSer.getPaginatedUserInterview(PageRequest.of(page, size));
	    User current_user = userServiceImpl.findByEmail(authentication.getName());
	    List<UserInterview> userInterviews = uiSer.findByUser(current_user);
	    Map<String, Object> response = new HashMap<>();
	      response.put("interviews", userInterviews);
	      response.put("currentPage", userInterviewPage.getNumber());
	      response.put("totalItems", userInterviewPage.getTotalElements());
	      response.put("totalPages", userInterviewPage.getTotalPages());
	    
	      return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
