package com.dcs.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="test_users")
public class UserTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "id_user")
	@JsonIgnore
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "id_test")
	private Test test;
	
	private Date do_at;
	
	private double calification;

	public UserTest(int id, User user, Test test, Date do_at, double calification) {
		super();
		this.id = id;
		this.user = user;
		this.test = test;
		this.do_at = do_at;
		this.calification = calification;
	}

	public UserTest() {
		super();
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

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Date getDo_at() {
		return do_at;
	}

	public void setDo_at(Date do_at) {
		this.do_at = do_at;
	}

	public double getCalification() {
		return calification;
	}

	public void setCalification(double calification) {
		this.calification = calification;
	}
	
	
}
