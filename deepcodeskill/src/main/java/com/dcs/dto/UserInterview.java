package com.dcs.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_interviews")
public class UserInterview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
 
    @ManyToOne
    @JoinColumn(name = "id_interview")
    private Interview interview;
    
    private int state;
    
    private String internal_comment;
    
    private int stamp;
    
    private Date joined_at;

	public UserInterview() {
		super();
	}

	public UserInterview(int id, User user, Interview interview, int state, String internal_comment, int stamp,
			Date joined_at) {
		super();
		this.id = id;
		this.user = user;
		this.interview = interview;
		this.state = state;
		this.internal_comment = internal_comment;
		this.stamp = stamp;
		this.joined_at = joined_at;
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

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getInternal_comment() {
		return internal_comment;
	}

	public void setInternal_comment(String internal_comment) {
		this.internal_comment = internal_comment;
	}

	public int getStamp() {
		return stamp;
	}

	public void setStamp(int stamp) {
		this.stamp = stamp;
	}

	public Date getJoined_at() {
		return joined_at;
	}

	public void setJoined_at(Date joined_at) {
		this.joined_at = joined_at;
	}

	@Override
	public String toString() {
		return "UserInterview [id=" + id + ", user=" + user + ", interview=" + interview + ", state=" + state
				+ ", internal_comment=" + internal_comment + ", stamp=" + stamp + ", joined_at=" + joined_at + "]";
	}
    
    

}
