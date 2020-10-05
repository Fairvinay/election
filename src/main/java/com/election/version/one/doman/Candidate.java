package com.election.version.one.doman;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Candidate {
	@Id
	@Column(name="CADIDATEID")
	int cadidateid;
	@Column(name = "FIRSTNAME")
	String firstname;
	@Column(name = "SURNAME")
	String surname;
	@Column(name = "BIRTHDATE")
	String birthdate;
	@Column(name = "VOTEZONE")
	String votezone;
	@Column (name="SYMBOL")
	String symbol;
	
     
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getCadidateid() {
		return cadidateid;
	}

	public void setCadidateid(int cadidateid) {
		this.cadidateid = cadidateid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getVotezone() {
		return votezone;
	}

	public void setVotezone(String votezone) {
		this.votezone = votezone;
	}

}