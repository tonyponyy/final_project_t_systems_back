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

import com.dcs.dto.UserInterview;
import com.dcs.service.IUserInterviewServiceImpl;

@RestController
@RequestMapping("/userinterviews")
public class UserInterviewController {
	
	@Autowired
	IUserInterviewServiceImpl uiSer;
	
	@GetMapping("/all")
	public List<UserInterview> listUserInterview(){
		return uiSer.listUserInterview();
	}
	
	@GetMapping("/{id}")
	public UserInterview listUserInterviewById(@PathVariable(name="id") Integer id) {
		return uiSer.listUserInterviewById(id);
	}
	
	@PostMapping("/add")
	public UserInterview saveUserInterview(@RequestBody UserInterview ui) {
		return uiSer.saveUserInterview(ui);
	}
	
	@PutMapping("/{id}")
	public UserInterview updateUserInterview(@PathVariable(name="id") Integer id, @RequestBody UserInterview ui) {
		UserInterview ui1 = uiSer.listUserInterviewById(id);
		UserInterview ui2 = new UserInterview();
		
		ui1.setId(ui.getId());
		ui1.setInterview(ui.getInterview());
		ui1.setUser(ui.getUser());
		ui1.setInternal_comment(ui.getInternal_comment());
		ui1.setJoined_at(ui.getJoined_at());
		ui1.setStamp(ui.getStamp());
		ui1.setState(ui.getState());
		
		ui2 = uiSer.updateUserInterview(ui1);
		
		return ui2;
	}
	
	@DeleteMapping("/{id}")
	public void deleteByIdUserInterview(@PathVariable(name="id") Integer id) {
		uiSer.deleteByIdUserInterview(id);
	}
	

}
