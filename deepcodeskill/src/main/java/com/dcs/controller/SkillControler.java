package com.dcs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dto.Skill;
import com.dcs.service.ISkillServiceImpl;

@RestController
@RequestMapping("/skills")
public class SkillControler {
	
	@Autowired
	ISkillServiceImpl sSer;
	
	/*ROLE RH
	  Listar skill, paginadas*/
	@GetMapping("/paginated_skills")
	public ResponseEntity<List<Skill>> getPaginatedSkills(
			@RequestParam(defaultValue = "0")int page,
			@RequestParam(defaultValue = "5") int size){
		
		Page<Skill> skillPage = sSer.getPaginatedSkills(PageRequest.of(page, size));
        List<Skill> skills = skillPage.getContent();

		return new ResponseEntity<> (skills, HttpStatus.OK);
		
	}
	
	/*ROLE RH
	  Añadir una nueva skill*/
	@PostMapping("/addSkill")
	public ResponseEntity<Skill> addSkill(@RequestBody Skill s){
		Skill s1 = sSer.addSkill(s);
		return new ResponseEntity<> (s1, HttpStatus.OK);
		
	}
	
	/*ROLE RH
	  Editar una skill*/
	@PutMapping("/editSkill/{id}")
	public Skill updateSkill(@PathVariable(name="id") Integer id, @RequestBody Skill s) {
		
		Skill s1 = sSer.listById(id);
		Skill s2 = new Skill();
		
		s1.setId(s.getId());
		s1.setDescription(s.getDescription());
		s1.setSkill_name(s.getSkill_name());
		
		s2 = sSer.updateSkill(s1);
		
		return s2;
	}
	
	/*ROLE RH
	  Borrar una skill*/
	@DeleteMapping("/deleteSkill/{id}")
	public void deleteByIdInterview (@PathVariable(name="id") Integer id) {
		sSer.deleteByIdSkill(id);
	}

}
