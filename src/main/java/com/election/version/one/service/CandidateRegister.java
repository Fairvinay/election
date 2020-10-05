package com.election.version.one.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.election.version.one.doman.Candidate;

import com.election.version.one.repository.CandidateRepository;

@Service  
public class CandidateRegister {

	@Autowired  
	CandidateRepository candidateRepository; 
	
	//getting all Candidate records  
	public List<Candidate> getAllCandidate()   
	{  
	List<Candidate> Candidates = new ArrayList<Candidate>();  
	  candidateRepository.findAll().forEach(Candidate -> Candidates.add(Candidate));  
	return Candidates;  
	}  
	//getting a specific record  
	public Candidate getCandidateById(int id)   
	{  
	  return candidateRepository.findById(id).get();  
	}  
	public void saveOrUpdate(Candidate Candidate)   
	{  
		candidateRepository.save(Candidate);  
	}  
	//deleting a specific record  
	public void delete(int id)   
	{  
		candidateRepository.deleteById(id);  
	}  
	
    public JSONArray getAllCandidates () {
		 
    	List<Candidate> candidates = new ArrayList<Candidate>();  
  	        candidateRepository.findAll().forEach(Candidate -> candidates.add(Candidate));  
  	    //Add can todidate list
  	      JSONArray candidateList = new JSONArray();
	
	      JSONObject candidateDetails = new JSONObject();
	     for( int i =0; i <  candidates.size() ; i++) {
	    	 Candidate cd = candidates.get(i);
	      candidateDetails.put("cadidateid",  cd.getCadidateid());
	      candidateDetails.put("firstname", cd.getFirstname());
	      candidateDetails.put("surname", cd.getSurname());
	      candidateDetails.put("birthdate", cd.getBirthdate());
	      candidateDetails.put("votezone", cd.getVotezone());
	         
	      JSONObject candidateObject = new JSONObject(); 
	      candidateObject.put("candidate", candidateDetails);
	        
	      candidateList.add(candidateObject);
	     }
	     
	     return candidateList;
	 }
	
	
	
}
