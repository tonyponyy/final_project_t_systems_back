package com.dcs.dto;

public class UserDTO {

	private String name;
	private String lastname;
	private String lastname2;

	public UserDTO(String name, String lastname, String lastname2) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.lastname2 = lastname2;
	}

	public UserDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLastname2() {
		return lastname2;
	}

	public void setLastname2(String lastname2) {
		this.lastname2 = lastname2;
	}

	
}
