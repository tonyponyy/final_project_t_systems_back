package com.dcs.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="interviews")
public class Interview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;
	
	private Date end_date;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Test> tests;

    @ManyToMany
    @JoinTable(
        name = "interview_skills",
        joinColumns = @JoinColumn(name = "id_interview"),
        inverseJoinColumns = @JoinColumn(name = "id_skill")
    )
    @JsonIgnoreProperties("interviews")
    private List<Skill> skills ;
    
    @OneToMany
    @JoinColumn(name="id")
    private List<UserInterview> userInterview;
    
	public Interview() {
		
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Interview(int id, String title, String description, Date end_date, List<Test> tests, List<Skill> skills) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.end_date = end_date;
		this.tests = tests;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "Test")
	public List<Test> getTests() {
		return tests;
	}

	public void setTests (List<Test> tests) {
		this.tests = tests;
	}
	
	

}
