package com.dcs.dto;

import java.util.List;

public class InterviewUserResponse {
    private Interview interview;
    private UserInterview user_interview;
    private List<UserTest> tests;

    public InterviewUserResponse(Interview interview, UserInterview user_interview,List<UserTest> tests) {
    	 if (interview != null) {
    		 this.interview = interview;
    	     this.user_interview = user_interview;
    	     this.tests = tests;
    	 }else {
    		 this.interview = null;
    	 }
        
    }

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	public UserInterview getUser_interview() {
		return user_interview;
	}

	public void setUser_interview(UserInterview user_interview) {
		this.user_interview = user_interview;
	}

	public List<UserTest> getTests() {
		return tests;
	}

	public void setTests(List<UserTest> tests) {
		this.tests = tests;
	}

}