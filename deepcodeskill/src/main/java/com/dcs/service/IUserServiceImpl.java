package com.dcs.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.IUserDAO;
import com.dcs.dto.User;


@Service
public class IUserServiceImpl implements IUserService {
	
	@Autowired
	IUserDAO iuserDAO;

	@Autowired
	IUserDAO icientificoDAO;

	//Listar todos
		public List<User> listUsers(){
			return iuserDAO.findAll();
		};
		
		//Listar por id
		public User userById(Integer id) {
			return iuserDAO.findById(id).get();
		}; 
		//Guardar
		public User saveUser(User user) {
			return iuserDAO.save(user);
		};
		//Actualizar
		public User updateUser(User user) {
			return iuserDAO.save(user);
		};
		//Eliminar
		public void deleteByIdUser(Integer id) {
			iuserDAO.deleteById(id);
		}
		
		public User findByEmail(String email) {
		    return iuserDAO.findByEmail(email).get();
		}


		   
	


}