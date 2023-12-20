package com.dcs.dto;

import java.sql.Date;

public class QualificateUserTest {
	private Date do_at;
	private double calification;
	public QualificateUserTest(Date do_at, double calification) {
		super();
		this.do_at = do_at;
		this.calification = calification;
	}
	public QualificateUserTest() {
		super();
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
