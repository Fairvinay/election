package com.election.version.one.doman;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table  
public class Ballot {
	
	String name;
	@Id
	@Column(name = "VOTEID")
	 int voteid;
    @Column(name="VOTECADIDATEID")
		int voteCadidateid;
    @Column(name="VOTEZONE")
	 String voteZone; 
	 
	public boolean equals (Object a) {
		Ballot b = (Ballot)a;
		
		return this.getName().equalsIgnoreCase(b.getName()) && 
		this.getVoteCadidateid() == b.getVoteCadidateid() &&
		this.getVoteid() == b.getVoteid() && 
		this.getVoteZone() == b.getVoteZone();
		
	}
		
	public String getVoteZone() {
		return voteZone;
	}
	public void setVoteZone(String votezone) {
		this.voteZone = votezone;
	}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getVoteid() {
			return voteid;
		}
		public void setVoteid(int voteid) {
			this.voteid = voteid;
		}
		public int getVoteCadidateid() {
			return voteCadidateid;
		}
		public void setVoteCadidateid(int votecadidateid) {
			this.voteCadidateid = votecadidateid;
		} 

}
