package com.dcs.service;

import java.util.List;

import com.dcs.dto.Resume;
import com.dcs.dto.Role;

public interface IResumeService {

	//Listar todos
		public List<Resume> listResumes();
		
		//Listar por id
		public Resume resumeById(Integer id); 
		
		//Guardar
		public Resume saveResume(Resume resume);
		
		//Actualizar
		public Resume updateResume(Resume resume);
		
		//Eliminar
		public void deleteByIdResume(Integer id);
		
}
