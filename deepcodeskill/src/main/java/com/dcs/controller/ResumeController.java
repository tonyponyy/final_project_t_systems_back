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

import com.dcs.dto.Resume;
import com.dcs.dto.Role;
import com.dcs.service.IResumeServiceImpl;
import com.dcs.service.IRoleServiceImpl;

import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/resumes")
public class ResumeController {
	@Autowired
	private IResumeServiceImpl impl;
	
	@Autowired
	private EntityManager entityManager;

	@GetMapping("/all")
	public List<Resume> listarResumes(){
		return impl.listResumes();
	}
	
	@PostMapping("/add")
	public Resume salvarResume(@RequestBody Resume resume) {
		return impl.saveResume(resume);
	}
	@GetMapping("/{id}")
	public Resume resumeXID(@PathVariable(name="id") Integer id) {
		Resume resume_xid = new Resume();
		resume_xid = impl.resumeById(id);
		return resume_xid;
	}
	
	@PutMapping("/{id}")
	public Resume actualizarResume(@PathVariable(name="id")Integer id,@RequestBody Resume resume) {
		Resume r1= new Resume();
		Resume r2= new Resume();
		
		r1.setId_user(resume.getId_user());
		r1.setResume(resume.getResume());
	
		r2 = impl.updateResume(r1);
		return r2;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarResume(@PathVariable(name="id")Integer id) {
		impl.deleteByIdResume(id);
	}

}
