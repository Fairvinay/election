package com.election.version.one.doman;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Vote {
	@Id
	@Column(name="VOTEID")
	int voteid;
	@Column(name = "VOTECADIDATEID")
	int voteCadidateid;

	@Column(name = "VOTEZONE")
	String votezone;

	public int getVoteid() {
		return voteid;
	}

	public void setVoteid(int voteid) {
		this.voteid = voteid;
	}

	public int getVoteCadidateid() {
		return voteCadidateid;
	}

	public void setVoteCadidateid(int voteCadidateid) {
		this.voteCadidateid = voteCadidateid;
	}

	public String getVotezone() {
		return votezone;
	}

	public void setVotezone(String votezone) {
		this.votezone = votezone;
	}

}
