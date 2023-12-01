package com.dcs.controller;

import java.util.List;
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

import com.dcs.dto.Interview;
import com.dcs.dto.InterviewBasic;
import com.dcs.dto.InterviewUserResponse;
import com.dcs.dto.User;
import com.dcs.dto.UserInterview;
import com.dcs.dto.UserTest;
import com.dcs.service.IInterviewServiceImpl;
import com.dcs.service.IUserInterviewService;
import com.dcs.service.IUserInterviewServiceImpl;
import com.dcs.service.IUserServiceImpl;
import com.dcs.service.IUserTestServiceImpl;

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
	
	@GetMapping("/all")
	public List<Interview> listInterview(){
		return iSer.listInterview();
	}
	
	@GetMapping("/all_basic")
	public ResponseEntity<List<InterviewBasic>> listInterviewBasic(){
		List<Interview> interviews = iSer.listInterview();
		List<InterviewBasic> interviews_basic = interviews.stream().map(this::ConvertInterview).collect(Collectors.toList());
		return new ResponseEntity<>(interviews_basic,HttpStatus.OK);
	}
	
	private InterviewBasic ConvertInterview(Interview interview){
		return new InterviewBasic(interview.getId(),interview.getTitle(),interview.getEnd_date(),interview.getSkills());
	}
	
	@GetMapping("/paginated_interviews")
	public ResponseEntity<List<InterviewBasic>>getPaginatedInterviewBasic(
			@RequestParam(defaultValue = "0")int page,
			@RequestParam(defaultValue = "5") int size){
		
		Page<Interview> interviewPage = iSer.getPaginatedInterviewBasic(PageRequest.of(page,size));
		List<InterviewBasic> interviews_basic = interviewPage.stream().map(this::ConvertInterview).collect(Collectors.toList());
		
		return new ResponseEntity<>(interviews_basic,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Interview listById(@PathVariable(name="id") Integer id) {
		return iSer.listById(id);
	}
	
	@PutMapping("/{id}")
	public Interview updateInterview(@PathVariable(name="id") Integer id, @RequestBody Interview i) {
		
		Interview i1 = iSer.listById(id);
		Interview i2 = new Interview();
		
		i1.setId(i.getId());
		i1.setDescription(i.getDescription());
		i1.setTitle(i.getTitle());
		i1.setTests(i.getTests());
		i1.setSkills(i.getSkills());
		i1.setEnd_date(i.getEnd_date());
		
		i2 = iSer.updateInterview(i1);
		
		return i2;
	}
	
	@PostMapping("/add")
	public Interview addInterview(@RequestBody Interview i) {
		return iSer.addInterview(i);
	}
	
	@DeleteMapping("/{id}")
	public void deleteByIdInterview (@PathVariable(name="id") Integer id) {
		iSer.deleteByIdInterview(id);
	}
	
	//show_interview_rh
		@GetMapping("/show_interview_rh/{id}")
		public Interview show_interview_rh(@PathVariable(name="id") Integer id) {
			return iSer.listById(id);
		}
		
		//show_interview_user
		@GetMapping("/show_interview_user/{id}")
		public ResponseEntity<InterviewUserResponse> show_interview_user(@PathVariable(name="id") Integer id) {
		    org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    User current_user = iuuSer.findByEmail(authentication.getName());
		    int user_id = current_user.getId();
			Interview interview = iSer.listById(id);
		    UserInterview user_interview = iuSer.findByUserIdAndInterviewId(user_id,id); 
		    List<UserTest> test_user = iutSer.findByUserIdAndInterviewId(user_id,id);
		    InterviewUserResponse response = new InterviewUserResponse(interview, user_interview,test_user);
		    return new ResponseEntity<>(response, HttpStatus.OK);
		}
		

}
