package com.election.version.one.doman;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class VoteZoneResult {
   
	@Id
	@Column(name="COUNT")
	
	
	public long count ; 
	@Column(name = "VOTEZONE")
	public String votezone;
	@Column(name = "VOTECADIDATEID")
	public int votecanditateId;
	
	public VoteZoneResult( int candidateid , long count) {
		this.count = count;
		this.votecanditateId  = candidateid;
	}
	public int getVotecanditateId() {
		return votecanditateId;
	}
	public void setVotecanditateId(int votecanditateId) {
		this.votecanditateId = votecanditateId;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getVotezone() {
		return votezone;
	}
	public void setVotezone(String votezone) {
		this.votezone = votezone;
	}
	public String toString() {
		return "VoteZone Result " + getVotecanditateId() + " " + getCount() +" ";
	}
	
	
}
