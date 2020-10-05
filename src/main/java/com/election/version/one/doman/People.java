package com.election.version.one.doman;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class People {
	
	@Id
	@Column(name="PEOPLE_CODE")
	int people_code;

	@Column(name = "NAME")
	String name;
	@Column(name = "VOTEZONE")
	String voteZone;

	public int getPeople_code() {
		return people_code;
	}

	public void setPeople_code(int people_code) {
		this.people_code = people_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVoteZone() {
		return voteZone;
	}

	public void setVoteZone(String voteZone) {
		this.voteZone = voteZone;
	}

}
