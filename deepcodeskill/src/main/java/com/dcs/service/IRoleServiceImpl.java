package com.dcs.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.IRoleDAO;
import com.dcs.dto.Role;


@Service
public class IRoleServiceImpl implements IRoleService {
	
	@Autowired
	IRoleDAO iroleDAO;


	//Listar todos
		public List<Role> listRoles(){
			return iroleDAO.findAll();
		};
		
		//Listar por id
		public Role roleById(Integer id) {
			return iroleDAO.findById(id).get();
		}; 
		//Guardar
		public Role saveRole(Role role) {
			return iroleDAO.save(role);
		};
		//Actualizar
		public Role updateRole(Role role) {
			return iroleDAO.save(role);
		};
		//Eliminar
		public void deleteByIdRole(Integer id) {
			iroleDAO.deleteById(id);
		}

		@Override
		public Role findByName(String name) {
			return iroleDAO.findByName(name);
		}


		   
	


}