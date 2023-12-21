package com.dcs.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_skills")
public class UserSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "id_skill")
    private Skill skill;
    
    private Double qualification;
    
    private String comment;
    
    public UserSkill() {
        super();
    }

	public UserSkill(int id, User user, Skill skill, Double qualification, String comment) {
		super();
		this.id = id;
		this.user = user;
		this.skill = skill;
		this.qualification = qualification;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Double getQualification() {
		return qualification;
	}

	public void setQualification(Double qualification) {
		this.qualification = qualification;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
    
}