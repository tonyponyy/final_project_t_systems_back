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

import com.dcs.dto.Test;
import com.dcs.service.ITestServiceImpl;

@RestController
@RequestMapping("/tests")
public class TestController {
	
	@Autowired
	ITestServiceImpl tSer;
	
	@GetMapping("/all")
	public List<Test> listTest(){
		return tSer.listTest();
	}
	
	@GetMapping("/{id}")
	public Test listTestById(@PathVariable(name="id") Integer id) {
		return tSer.listTestById(id);
	}
	
	@PostMapping("/add")
	public Test newTest(@RequestBody Test t) {
		return tSer.saveTest(t);
	}
	
	@PutMapping("/{id}")
	public Test updateTest(@PathVariable(name="id") Integer id, @RequestBody Test t) {
		Test t1 = tSer.listTestById(id);
		Test t2 = new Test();
		
		t1.setId(t.getId());
		t1.setName(t.getName());
		t1.setDescription(t.getDescription());
		t1.setEnd_date(t.getEnd_date());
		
		t2 = tSer.updateTest(t1);
		return t2;
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(name="id") Integer id) {
		tSer.deleteByIdTest(id);
	}

}
