package com.dcs.service;

import java.util.List;

import com.dcs.dto.User;


public interface IUserService {
	
	//Listar todos
	public List<User> listUsers();
	
	//Listar por id
	public User userById(Integer id); 
	
	//Guardar
	public User saveUser(User User);
	
	//Actualizar
	public User updateUser(User User);
	
	//Eliminar
	public void deleteByIdUser(Integer id);

	
}