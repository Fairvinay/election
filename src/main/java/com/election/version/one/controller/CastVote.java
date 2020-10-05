package com.election.version.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.election.version.one.service.PublicRegisterService;
import com.election.version.one.service.VoteService;

@RestController
public class CastVote {

	 @Autowired
	   VoteService voteService;
	 @Autowired
	 PublicRegisterService pubService;
	 
		
	 @GetMapping	("/castvote")
	 public String register (@RequestParam(value="voteid" ,defaultValue="-1") String voteid,
			 @RequestParam(value="votecadidateid" ,defaultValue="-1") String votecandidateid,
			 @RequestParam(value="votezone" ,defaultValue="-1") String votezone,
			 @RequestParam(value="name" ,defaultValue="world") String name) {
		 
		String status = "";
					
		if( ! pubService.getPeopleByName(name)) {
			status = "person not registered";
		}
		else if (!voteService.checkVoteAlreadyDone(votecandidateid, voteid, votezone, name) ){
		  
			voteService.castVote(votecandidateid, voteid, votezone, name);
			status = "saved";
		}
		else {
			status = "already vote done";
		}
	
		return status;
		
	}
}
