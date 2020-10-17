package com.election.version.one.doman;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	Date birthdate;
	@Column(name = "VOTEZONE")
	String votezone;
	@Column (name="SYMBOL")
	String symbol;
	
     @SuppressWarnings("deprecation")
	public Candidate() {
    	 
    	 this.birthdate =new Date(10,10,1970); 
 		this.cadidateid = 0;
 		this.firstname = "";
 		this.surname = "";
 		this.symbol = "";
 		this.votezone = "";
     }
	public Candidate(String string, String string2, String string3, String string4, String string5, String string6) throws ParseException {
		this.birthdate = new Date(new SimpleDateFormat("dd-MM-YYYY").parse(string).getTime()); 
		this.cadidateid = Integer.parseInt(string2);
		this.firstname = string3;
		this.surname = string4;
		this.symbol = string5;
		this.votezone = string6;
	}

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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate =  birthdate;
	}

	public String getVotezone() {
		return votezone;
	}

	public void setVotezone(String votezone) {
		this.votezone = votezone;
	}
	
	public String toString() {
		
		return "Candidate " + getCadidateid() + " "+ getFirstname() +" "+ getSurname() +" "+getBirthdate() + " "+getVotezone() ;
	}

}