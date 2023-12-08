package com.dcs.dto;

import java.util.Date;
import java.util.List;

public class InterviewBasic {
	

	private int id;
	
	private String title;
	
	private Date end_date;
	
	private List<Skill> skills;
   
	public InterviewBasic() {
		
	}



	public InterviewBasic(int id, String title, Date end_date, List<Skill> skills) {
		super();
		this.id = id;
		this.title = title;
		this.end_date = end_date;
		this.skills = skills;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}




	

}

