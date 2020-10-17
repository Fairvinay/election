package com.election.version.one.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.election.version.one.doman.Ballot;
import com.election.version.one.doman.Candidate;
import com.election.version.one.doman.Vote;
import com.election.version.one.doman.VoteZoneResult;
import com.election.version.one.repository.BallotRepository;
import com.election.version.one.repository.BallotResultRepository;
import com.election.version.one.repository.CandidateRepository;
import com.election.version.one.repository.VoteRepository;

@Service

public class VoteService {

	@Autowired  
	VoteRepository voteRepository; 
	@Autowired  
	BallotRepository ballotRepository; 
	@Autowired  
	BallotResultRepository ballotResultRepository; 
	@Autowired  
	CandidateRepository candidateRepository; 
	
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
	
	public Candidate winnerBallot() { 
		
		int cntVotes =0; 
		VoteZoneResult basoc = null;
		
		List<VoteZoneResult> voteCount  = ballotResultRepository.findVotes();
		
		List<VoteZoneResult> winList= new ArrayList<>();
	    winList.add( new VoteZoneResult(4,2)) ;
	    winList.add( new VoteZoneResult(4,3)) ;
		/*
		 * final Integer cnt = 0; voteCount .stream() .forEach(x -> {if (cnt < x.count )
		 * { cnt = x.count; }});
		 */
	    VoteZoneResult val =   voteCount.stream().max(Comparator.comparing(VoteZoneResult::getCount)).get();
	    System.out.println("Winner  "+val);
	    
	    int winCnt = (int)val.getCount();
	    List<VoteZoneResult> tolWin = winList.stream().takeWhile(e-> e.getCount() == winCnt).collect(Collectors.toList());
        List<Candidate> calList= new ArrayList<>();
	    if(tolWin.size() > 1 ) {
	    	System.out.println("Tie in Winners ");
	    	
	    	tolWin.forEach( e -> { 
	    		
	    		Optional<Candidate> cd =  candidateRepository.findByCandidateId(e.getVotecanditateId());
	    		if(cd.isPresent()){
	    			calList.add(cd.get());
	    		}
	    		
	    	});
	    	calList.sort(Comparator.comparing(Candidate::getFirstname).thenComparing(Candidate::getSurname).thenComparing(Candidate::getBirthdate));

	    }
	    else if (tolWin.size() ==0) {
	    	System.out.println("Single Winner  ");
	    		Optional<Candidate> cd =  candidateRepository.findByCandidateId(val.getVotecanditateId());
	    		if(cd.isPresent()){
	    			calList.add(cd.get());
	    		}
	    		else {
	    			System.out.println(" no Candidate found ");
	    		}
	    		
	    	 
	    }
	    	    
	   
	    
		/*
		 * Object distinctVotes = winList.stream()
		 * .collect(Collectors.collectingAndThen( Collectors.toMap(c ->
		 * Arrays.asList(c.getVotecanditateId(), c.getCount()), Function.identity(),
		 * (a,b) -> a, LinkedHashMap::new), m -> new ArrayList<>(m.values())));
		 */
		
		
		
		
		return   calList.get(0) ;
		
	}
}
