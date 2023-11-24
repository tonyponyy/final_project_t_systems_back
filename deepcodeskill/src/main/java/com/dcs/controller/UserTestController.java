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

import com.dcs.dto.UserTest;
import com.dcs.service.IUserTestServiceImpl;

@RestController
@RequestMapping("/usertests")
public class UserTestController {
	
	@Autowired
	IUserTestServiceImpl uSer;
	
	@GetMapping("/all")
	public List<UserTest> listUserTest(){
		return uSer.listUserTest();
	}
	
	@GetMapping("/{id}")
	public UserTest listById(@PathVariable(name="id") Integer id) {
		return uSer.listById(id);
	}
	
	@PutMapping("/{id}")
	public UserTest updateUserTest(@PathVariable(name="id") Integer id, @RequestBody UserTest u) {
		
		UserTest u1 = uSer.listById(id);
		UserTest u2 = new UserTest();
		
		u1.setId(u.getId());
		u1.setUser(u.getUser());
		u1.setTest(u.getTest());
		u1.setDo_at(u.getDo_at());
		u1.setCalification(u.getCalification());
		
		u2 = uSer.updateUserTest(u1);
		
		return u2;
	}
	
	@PostMapping("/add")
	public UserTest addUserTest(@RequestBody UserTest u) {
		return uSer.addUserTest(u);
	}
	
	@DeleteMapping("/{id}")
	public void deleteByIdUserTest (@PathVariable(name="id") Integer id) {
		uSer.deleteByIdUserTest(id);
	}
}
