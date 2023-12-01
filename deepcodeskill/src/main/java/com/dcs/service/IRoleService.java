package com.dcs.service;

import java.util.List;

import com.dcs.dto.Role;


public interface IRoleService {
	
	//Listar todos
	public List<Role> listRoles();
	
	//Listar por id
	public Role roleById(Integer id); 
	
	//Guardar
	public Role saveRole(Role Role);
	
	//Actualizar
	public Role updateRole(Role Role);
	
	//Eliminar
	public void deleteByIdRole(Integer id);

	public Role findByName(String name);
	
}