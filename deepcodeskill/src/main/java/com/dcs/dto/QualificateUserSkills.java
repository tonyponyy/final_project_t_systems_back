package com.dcs.dto;

public class QualificateUserSkills {
	public String comment;
	public Double qualification;
	
	public QualificateUserSkills(String comment, Double qualification) {
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

	public Double getQualification() {
		return qualification;
	}

	public void setQualification(Double qualification) {
		this.qualification = qualification;
	}
	

}
