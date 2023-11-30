package com.dcs.jwt;

import lombok.Data;

@Data
public class JWTAuthenticationRequest {
    private String username;
    private String password;
    
	public JWTAuthenticationRequest(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
	}
	
	public JWTAuthenticationRequest() {
		super();
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}