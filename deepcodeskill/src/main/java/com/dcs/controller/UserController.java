package com.dcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dcs.dto.User;
import com.dcs.service.IUserServiceImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private IUserServiceImpl userServiceImpl;
	@Autowired
	private EntityManager entityManager;

	@GetMapping("/all")
	public List<User> listarUsers(){
		return userServiceImpl.listUsers();
	}
	@PostMapping("/add")
	public User salvaruser(@RequestBody User user) {
		return userServiceImpl.saveUser(user);
	}
	@GetMapping("/{id}")
	public User userXID(@PathVariable(name="id") Integer id) {
		User user_xid= new User();	
		user_xid=userServiceImpl.userById(id);
		return user_xid;
	}
	
	@PutMapping("/{id}")
	public User actualizaruser(@PathVariable(name="id") Integer id, @RequestBody User user) {
	    User user_seleccionado = userServiceImpl.userById(id);

	    if (user.getName() != null) {
	        user_seleccionado.setName(user.getName());
	    }

	    if (user.getLastname() != null) {
	        user_seleccionado.setLastname(user.getLastname());
	    }

	    if (user.getLastname2() != null) {
	        user_seleccionado.setLastname2(user.getLastname2());
	    }

	    if (user.getPassword() != null) {
	        user_seleccionado.setPassword(user.getPassword());
	    }

	    if (user.getEmail() != null) {
	        user_seleccionado.setEmail(user.getEmail());
	    }

	    if (user.getResume() != null) {
	        user_seleccionado.setResume(user.getResume());
	    }

	    if (user.getRole() != null) {
	        user_seleccionado.setRole(user.getRole());
	    }

	    if (user.getPhoto() != null) {
	        user_seleccionado.setPhoto(user.getPhoto());
	    }

	    User user_updated = userServiceImpl.updateUser(user_seleccionado);
	    return user_updated;
	}
	
	@DeleteMapping("/{id}")
	public void eliminaruser(@PathVariable(name="id")Integer id) {
		userServiceImpl.deleteByIdUser(id);
	}
	
}