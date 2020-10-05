package com.election.version.one.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.election.version.one.doman.Ballot;
import com.election.version.one.doman.People;
import com.election.version.one.doman.Vote;
import com.election.version.one.doman.VoteZoneResult;
import com.election.version.one.repository.BallotRepository;
import com.election.version.one.repository.VoteRepository;

@Service

public class VoteService {

	@Autowired  
	VoteRepository voteRepository; 
	@Autowired  
	BallotRepository ballotRepository; 
	
	
	VoteZoneResult vrz ;
	
	
	// get Ballot for CastVote 
	public boolean checkVoteAlreadyDone( String votecandidateid, String  voteid , String votezone, String name) {
		
		Ballot b = new Ballot();
		 b.setVoteid(Integer.parseInt(voteid));
		 b.setVoteCadidateid(Integer.parseInt(votecandidateid));
		 b.setVoteZone(votezone);
		 b.setName(name);
		 List<Ballot> bl = new ArrayList<>();
		 ballotRepository.findAll().forEach(Ballot -> bl.add(Ballot));  
		   List<Ballot> fndList = bl.stream().filter(p -> p.equals(b)).collect(Collectors.toList());
		   
		return fndList.size() == 0 ? true: false;  
	
		
	}
	// add Vote in Ballot 
	public boolean castVote(String votecandidateid, String  voteid , String votezone, String name) {
		
		 Ballot b = new Ballot();
		 b.setVoteid(Integer.parseInt(voteid));
		 b.setVoteCadidateid(Integer.parseInt(votecandidateid));
		 b.setVoteZone(votezone);
		 b.setName(name);
		 Ballot bs = ballotRepository.save(b);
		 
		 return bs!=null;
	}
	
	
	//getting all Vote records  
		public List<Vote> getAllCandidate()   
		{  
		  List<Vote> Votes = new ArrayList<Vote>();  
	    	voteRepository.findAll().forEach(Vote -> Votes.add(Vote));  
		   return Votes;  
		}  
		//getting a specific record  
		public Vote getCandidateById(int id)   
		{  
		  return voteRepository.findById(id).get();  
		}  
		public void saveOrUpdate(Vote Vote)   
		{  
			voteRepository.save(Vote);  
		}  
		//deleting a specific record  
		public void delete(int id)   
		{  
			voteRepository.deleteById(id);  
		}  
	
	public VoteZoneResult countVotes() { 
		
		int cntVotes =0; 
		VoteZoneResult basoc = null;
		
		System.out.println("Basic "+basoc);
		
		
		return basoc;
		
	}
}
