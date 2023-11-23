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

import com.dcs.dto.Interview;
import com.dcs.service.InterviewServicesImpl;

@RestController
@RequestMapping("/api")
public class InterviewController {
	
	@Autowired
	InterviewServicesImpl iSer;
	
	@GetMapping("/interview")
	public List<Interview> listInterview(){
		return iSer.listInterview();
	}
	
	@GetMapping("/interview/{id}")
	public Interview listById(@PathVariable(name="id") Integer id) {
		return iSer.listById(id);
	}
	
	@PutMapping("/interview/{id}")
	public Interview updateInterview(@PathVariable(name="id") Integer id, @RequestBody Interview i) {
		
		Interview i1 = iSer.listById(id);
		Interview i2 = new Interview();
		
		i1.setId(i.getId());
		i1.setDescription(i.getDescription());
		i1.setTitle(i.getTitle());
		i1.setEnd_date(i.getEnd_date());
		
		i2 = iSer.updateInterview(i1);
		
		return i2;
	}
	
	@PostMapping("/interview")
	public Interview addInterview(@RequestBody Interview i) {
		return iSer.addInterview(i);
	}
	
	@DeleteMapping("/interview/{id}")
	public void deleteByIdInterview (@PathVariable(name="id") Integer id) {
		iSer.deleteByIdInterview(id);
	}

}
