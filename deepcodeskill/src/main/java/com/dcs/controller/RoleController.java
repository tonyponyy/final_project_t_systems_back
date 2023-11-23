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


import com.dcs.dto.Role;
import com.dcs.service.IRoleServiceImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private IRoleServiceImpl roleServiceImpl;
	@Autowired
	private EntityManager entityManager;

	@GetMapping("/all")
	public List<Role> listarRoles(){
		return roleServiceImpl.listRoles();
	}
	@PostMapping("/add")
	public Role salvarrole(@RequestBody Role role) {
		return roleServiceImpl.saveRole(role);
	}
	@GetMapping("/{id}")
	public Role roleXID(@PathVariable(name="id") Integer id) {
		Role role_xid= new Role();	
		role_xid=roleServiceImpl.roleById(id);
		return role_xid;
	}
	
	@PutMapping("/{id}")
	public Role actualizarrole(@PathVariable(name="id")Integer id,@RequestBody Role role) {
		Role role_seleccionado= new Role();
		Role role_updated= new Role();
		role_seleccionado= roleServiceImpl.roleById(id);
		role_seleccionado.setName(role.getName());
		role_updated = roleServiceImpl.updateRole(role_seleccionado);
		return role_updated;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarrole(@PathVariable(name="id")Integer id) {
		roleServiceImpl.deleteByIdRole(id);
	}
	
}