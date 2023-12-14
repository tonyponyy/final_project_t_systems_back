package com.dcs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dcs.dto.Interview;
import com.dcs.dto.InterviewBasic;
import com.dcs.dto.InterviewUserResponse;
import com.dcs.dto.User;
import com.dcs.dto.UserInterview;
import com.dcs.dto.UserTest;
import com.dcs.service.IInterviewServiceImpl;
import com.dcs.service.IUserInterviewServiceImpl;
import com.dcs.service.IUserServiceImpl;
import com.dcs.service.IUserTestServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/interviews")
public class InterviewController {

	@Autowired
	IInterviewServiceImpl iSer;

	@Autowired
	IUserServiceImpl iuuSer;

	@Autowired
	IUserInterviewServiceImpl iuSer;

	@Autowired
	IUserTestServiceImpl iutSer;

	private InterviewBasic ConvertInterview(Interview interview) {
		return new InterviewBasic(interview.getId(), interview.getTitle(), interview.getEnd_date(),
				interview.getSkills());
	}

	/*
	 * ROLE USUARIO y RH Lista todas las entrevistas paginadas
	 */
	@GetMapping("/paginated_interviews")
	public ResponseEntity<Map<String, Object>> getPaginatedInterviewBasic(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {

		Page<Interview> interviewPage = iSer.getPaginatedInterviewBasic(PageRequest.of(page, size));
		List<InterviewBasic> interviews_basic = interviewPage.stream().map(this::ConvertInterview)
				.collect(Collectors.toList());
		
		  Map<String, Object> response = new HashMap<>();
	      response.put("interviews", interviews_basic);
	      response.put("currentPage", interviewPage.getNumber());
	      response.put("totalItems", interviewPage.getTotalElements());
	      response.put("totalPages", interviewPage.getTotalPages());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/*
	 * ROLE USUARIO y RH Buscar entrevista por titulo
	 */
	@GetMapping("/search_by/{title}")
	public ResponseEntity<List<InterviewBasic>> getPaginatedInterviewBasicTitle(
			@PathVariable(name = "title") String title, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {

		Page<Interview> interviewPage = iSer.getPaginatedInterviewBasicTitle(title, page, size);
		List<InterviewBasic> interviews_basic = interviewPage.stream().map(this::ConvertInterview)
				.collect(Collectors.toList());

		return new ResponseEntity<>(interviews_basic, HttpStatus.OK);

	}

	/*
	 * ROLE RH Añadir una nueva entrevista
	 */
	@PostMapping("/addInterview")
	public ResponseEntity<Interview> addInterview(@RequestBody Interview i) {
		Interview i1 = iSer.addInterview(i);
		return new ResponseEntity<>(i1, HttpStatus.OK);
	}

	/*
	 * ROLE RH Editar una entrevista
	 */
	@PutMapping("/editInterview/{id}")
	public Interview updateInterview(@PathVariable(name = "id") Integer id, @RequestBody Interview i) {

		Interview i1 = iSer.listById(id);
		Interview i2 = new Interview();

		if (i.getDescription() != null) {
			i1.setDescription(i.getDescription());
		}
		if (i.getTitle() != null) {
			i1.setTitle(i.getTitle());
		}
		if (i.getTests() != null) {
			i1.setTests(i.getTests());
		}
		if (i.getSkills() != null) {
			i1.setSkills(i.getSkills());
		}
		if (i.getEnd_date() != null) {
			i1.setEnd_date(i.getEnd_date());
		}

		i2 = iSer.updateInterview(i1);

		return i2;
	}

	/*
	 * ROLE RH Eliminar una entrevista
	 */
	@DeleteMapping("/deleteInterview/{id}")
	public void deleteByIdInterview(@PathVariable(name = "id") Integer id) {
		iSer.deleteByIdInterview(id);
	}

	/*
	 * ROLE RH Entrevista con informacionpara el usuario de rh
	 */
	@GetMapping("/show_interview_rh/{id}")
	public Interview show_interview_rh(@PathVariable(name = "id") Integer id) {
		System.out.println("INTERVIEW" + iSer.listById(id).getTests());
		return iSer.listById(id);
	}

	/*
	 * ROLE USUARIO Entrevista con informacion basica
	 */
	@GetMapping("/show_interview_user/{id}")
	public ResponseEntity<InterviewUserResponse> show_interview_user(@PathVariable(name = "id") Integer id) {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		User current_user = iuuSer.findByEmail(authentication.getName());
		int user_id = current_user.getId();
		Interview interview = iSer.listById(id);
		UserInterview user_interview = iuSer.findByUserIdAndInterviewId(user_id, id);
		List<UserTest> test_user = iutSer.findByUserIdAndInterviewId(user_id, id);
		InterviewUserResponse response = new InterviewUserResponse(interview, user_interview, test_user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
