package com.dcs.service;

import java.util.List;

import com.dcs.dto.Interview;

public interface IIterviewService {
	
	public List<Interview> listInterview();
	
	public Interview listById(Integer id);
	
	public Interview updateInterview(Interview i);
	
	public Interview addInterview(Interview i);
	
	public void deleteByIdInterview(Integer id);

}
