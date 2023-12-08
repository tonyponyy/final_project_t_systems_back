package com.dcs.service;

import com.dcs.dto.Role;

public interface IRoleService {
	
	public Role findByName(String name);
	
}