package com.election.version.one.webmodel;

public class RegisterRequest {

	String firstName;
	String lastName;
	String email;
	String phone;
	String password;
	String voteZone;

	public String getVoteZone() {
		return voteZone;
	}

	public void setVoteZone(String voteZone) {
		this.voteZone = voteZone;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String toString() {
		return "RegisterRequest : [{ name " +getEmail()+ " password "+getPassword()+" " + "phone " 
	     +getPhone()+ " firstname "+getFirstName()+ " lastname " + getLastName()+"  zone  " + getVoteZone()+ " }]";
	}
}
