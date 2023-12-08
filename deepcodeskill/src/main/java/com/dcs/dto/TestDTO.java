package com.dcs.dto;

import java.util.Date;

public class TestDTO {

	private String name;
	private String description;
	private int id_interview;
	private Date end_date;

	public TestDTO() {
	
	}
	public TestDTO(String name, String description, int id_interview, Date end_date) {
		super();
		this.name = name;
		this.description = description;
		this.id_interview = id_interview;
		this.end_date = end_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId_interview() {
		return id_interview;
	}
	public void setId_interview(int id_interview) {
		this.id_interview = id_interview;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	
}
