package com.dcs.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dcs.dto.Interview;

public interface IIterviewService {
		
	public Interview listById(Integer id);
	
	public Interview updateInterview(Interview i);
	
	public Interview addInterview(Interview i);
	
	public void deleteByIdInterview(Integer id);
	
	//metodo para la paginacion
	Page<Interview> getPaginatedInterviewBasic(Pageable pageable);
	
	Page<Interview> getPaginatedInterviewBasicTitle(String name, int page, int size);

}
