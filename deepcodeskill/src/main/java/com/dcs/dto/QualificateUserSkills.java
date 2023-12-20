package com.dcs.dto;

public class QualificateUserSkills {
	public String comment;
	public Float qualification;
	
	public QualificateUserSkills(String comment, Float qualification) {
		super();
		this.comment = comment;
		this.qualification = qualification;
	}

	public QualificateUserSkills() {
		super();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public float getQualification() {
		return qualification;
	}

	public void setQualification(Float qualification) {
		this.qualification = qualification;
	}
	

}
