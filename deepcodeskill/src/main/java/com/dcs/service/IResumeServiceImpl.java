package com.dcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.IResumeDAO;
import com.dcs.dto.Resume;

@Service
public class IResumeServiceImpl implements IResumeService{

	@Autowired
	IResumeDAO dao;
	
	@Override
	public List<Resume> listResumes() {
		return dao.findAll();
	}

	@Override
	public Resume resumeById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Resume saveResume(Resume resume) {
		return dao.save(resume);
	}

	@Override
	public Resume updateResume(Resume resume) {
		return dao.save(resume);
	}

	@Override
	public void deleteByIdResume(Integer id) {
		dao.deleteById(id);
		
	}

}
