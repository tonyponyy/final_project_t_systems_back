package com.dcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.IRoleDAO;
import com.dcs.dto.Role;

@Service
public class IRoleServiceImpl implements IRoleService {
	
	@Autowired
	IRoleDAO iroleDAO;

	@Override
	public Role findByName(String name) {
		return iroleDAO.findByName(name);
	}

}