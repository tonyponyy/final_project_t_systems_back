package com.dcs.jwt;

public class SignUpRequest {

	private String firstName;
	private String lastName;
	private String lastName2;
	private String email;
	private String password;
	
	
	public SignUpRequest(String firstName, String lastName, String lastName2, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastName2 = lastName2;
		this.email = email;
		this.password = password;
	}

	public SignUpRequest() {
		super();
	
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	
	
}
