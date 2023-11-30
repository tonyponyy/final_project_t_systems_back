package com.dcs.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dcs.dto.Interview;
import com.dcs.dto.InterviewBasic;

public interface IIterviewService {
	
	public List<Interview> listInterview();
	
	public Interview listById(Integer id);
	
	public Interview updateInterview(Interview i);
	
	public Interview addInterview(Interview i);
	
	public void deleteByIdInterview(Integer id);
	
	//metodo para la paginacion
	Page<Interview> getPaginatedInterviewBasic(Pageable pageable);

}
