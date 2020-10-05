package com.election.version.one.webmodel;

public class LoginRequest {
	
	private String email = "taba";

	private String password = "abat";
	private String token = "";

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String name) {
		this.email = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

		public String toString() {
			return "LoginRequest : [{ name " +getEmail()+ " password "+getPassword()+" }]";
		}

}
