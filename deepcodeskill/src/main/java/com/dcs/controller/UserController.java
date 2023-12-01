package com.dcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.Resume;
import com.dcs.dto.User;
import com.dcs.service.IResumeServiceImpl;
import com.dcs.service.IUserServiceImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private IUserServiceImpl userServiceImpl;
	@Autowired
	private IResumeServiceImpl resumeServiceImpl;
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
	
	@PostMapping("/photo")
	public ResponseEntity add_photo(@RequestBody byte[] photo) {
		
		try {
			System.out.println("TEST PHOTO");
		    org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    User current_user = userServiceImpl.findByEmail(authentication.getName());
		    //User current_user = userServiceImpl.findByEmail("test@test.com");
		    System.out.println("EMAIL USER :"+current_user.getEmail());
			if (photo != null) {
		        current_user.setPhoto(photo);
		        userServiceImpl.saveUser(current_user);
		    }
	        return ResponseEntity.ok("Photo added successfully");
	    } catch (Exception e) {
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding photo");
	    }
		
		
	}
	
	@PostMapping("/resume")
	public ResponseEntity add_resume(@RequestBody byte[] resume) {
		
		try {
			System.out.println("TEST RESUME");
		    org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    User current_user = userServiceImpl.findByEmail(authentication.getName());
		    //User current_user = userServiceImpl.findByEmail("test@test.com");
		    System.out.println("EMAIL USER :"+current_user.getEmail());
			if (resume != null) {
				Resume r = new Resume();
				r.setId_user(current_user.getId());
				r.setResume(resume);	
		        resumeServiceImpl.saveResume(r);
		        
		        current_user.setResume(r);
		        
		        userServiceImpl.saveUser(current_user);
		        
		        
		    }
	        return ResponseEntity.ok("Resume added successfully");
	    } catch (Exception e) {
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding photo");
	    }
		
		
	}
	
	@PutMapping("/{id}")
	public User actualizaruser(@PathVariable(name="id") Integer id, @RequestBody User user) {
	    User user_seleccionado = userServiceImpl.userById(id);

	    if (user.getName() != null) {
	        user_seleccionado.setName(user.getName());
	    }
	    
	    if (user.getSkills() != null) {
	        user_seleccionado.setSkills(user.getSkills());
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

//	    if (user.getResume_id() != null) {
//	        user_seleccionado.setResume(user.getResume());
//	    }

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