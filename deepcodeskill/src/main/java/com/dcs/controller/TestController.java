package com.dcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.Interview;
import com.dcs.dto.Test;
import com.dcs.dto.TestDTO;
import com.dcs.service.IInterviewServiceImpl;
import com.dcs.service.ITestServiceImpl;

@RestController
@RequestMapping("/tests")
public class TestController {
	
	@Autowired
	ITestServiceImpl tSer;
	
	@Autowired
	IInterviewServiceImpl iSer;
	
	/*ROLE RH
	  Añadir un test*/
	@PostMapping("/addTest")
	public ResponseEntity<Test> addTest(@RequestBody TestDTO test){
		Interview i = iSer.listById(test.getId_interview());
		
		Test t1 = new Test();
		
		t1.setName(test.getName());
		t1.setDescription(test.getDescription());
		t1.setInterview(i);
		t1.setEnd_date(test.getEnd_date());
		
		i.getTests().add(t1);
		
		tSer.saveTest(t1);
		return new ResponseEntity<> (t1, HttpStatus.OK);
	}
	
	/*ROLE RH
	  Editar un test*/
	@PutMapping("/editTest/{id}")
	public Test updateTest(@PathVariable(name="id") Integer id, @RequestBody TestDTO t) {
		Interview i = iSer.listById(t.getId_interview());

		Test t1 = tSer.listTestById(id);
		Test t2 = new Test();
		
		t1.setName(t.getName());
		t1.setDescription(t.getDescription());
		t1.setInterview(i);
		t1.setEnd_date(t.getEnd_date());
		
		i.getTests().add(t1);

		t2 = tSer.updateTest(t1);
		
		return t2;
	}
	
	/*ROLE RH
	  Borrar un test*/
	@DeleteMapping("/deleteTest/{id}")
	public void deleteByIdTest (@PathVariable(name="id") Integer id) {
		tSer.deleteByIdTest(id);
	}

}
