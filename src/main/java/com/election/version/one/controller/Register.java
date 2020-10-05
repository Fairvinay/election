package com.election.version.one.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.election.version.one.doman.Candidate;
import com.election.version.one.doman.People;
import com.election.version.one.service.CandidateRegister;
import com.election.version.one.service.PublicRegisterService;
import com.election.version.one.webmodel.CandidateResponse;
import com.election.version.one.webmodel.LoginRequest;
import com.election.version.one.webmodel.RegisterRequest;

@RestController
public class Register {
	@Autowired
	PublicRegisterService pubService;
    @Autowired 
    CandidateRegister  cadService; 
	Logger logger = LoggerFactory.getLogger(Register.class);

	@GetMapping("/publicregister")
	public String register(@RequestParam(value = "name", defaultValue = "World") String personName,
			@RequestParam(value = "votezone", defaultValue = "Kharadi") String voteZone) {
		String status = "";

		if (!pubService.getPeopleByName(personName)) {
			logger.info(" Registering {} ", personName);
			People p = new People();
			p.setName(personName);
			p.setVoteZone(voteZone);
			pubService.saveOrUpdate(p);
			status = "saved";
		} else {
			status = "already registered";
		}

		return status;

	}
	
	@GetMapping(path="/candidates",  produces = { MediaType.APPLICATION_JSON_VALUE})
	public List<CandidateResponse>  getCandidates( ) {
		String status = "";

		List<CandidateResponse> crl = new ArrayList<>();
		List<Candidate> canArray =cadService.getAllCandidate();
		
		canArray.forEach(c -> { CandidateResponse cr = new CandidateResponse();
				    cr.cadidateid = c.getCadidateid();
				    cr.birthdate = c.getBirthdate();
				    cr.firstname = c.getFirstname();
				    cr.surname = c.getSurname();
				    cr.votezone  = c.getVotezone();
				    cr.symbol = c.getSymbol();
				    crl.add(cr);
		});
		
	   
		
	
		return   crl;

	}
	
	
	@PostMapping(path ="auth/register",  consumes = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object>  register(@RequestBody RegisterRequest registerequest) {
		String status = "";
		
		 String personName = registerequest.getFirstName();
		 String voteZone = registerequest.getVoteZone();
		 JSONObject entity = new JSONObject();
		 logger.info(" register RegisterReqest"
		 		+ " {} ", registerequest);
		if (!pubService.getPeopleByName(personName)) {
			logger.info(" Registering {} ", personName);
			People p = new People(); 
			 entity.put("saved", "true");
			p.setName(personName);
			p.setVoteZone(voteZone);
			pubService.saveOrUpdate(p);
			status = "saved";
		} else {
			status = "already registered";
			 entity.put("saved", "false");
		}

		return new ResponseEntity<Object>(entity, HttpStatus.OK);

	}

	

	@PostMapping(path = "/auth/loginform", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ResponseEntity<String> loginform (LoginRequest loginrequest) throws Exception {
		 
		ResponseEntity req = new ResponseEntity<String>("You logged in success fully ", HttpStatus.OK);
		
		if (loginrequest.getEmail().equalsIgnoreCase("taba") && loginrequest.getPassword().equalsIgnoreCase("abat")) {
			req.status(HttpStatus.BAD_REQUEST);
		}
		else { 
			if (pubService.getPeopleByName(loginrequest.getEmail())) {
				
				req.status(HttpStatus.OK);
			}
		}
		
		return req;
		 
	}
	
	@PostMapping(path = "/auth/login", consumes = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> login (@RequestBody LoginRequest loginrequest) throws Exception {
		 
	   logger.info("auth login {} " , loginrequest);
		ResponseEntity req = new ResponseEntity<String>("You logged in success fully ", HttpStatus.OK);
		 JSONObject entity = new JSONObject();
		 String token  = this.makeid(23);
		if (loginrequest.getEmail().equalsIgnoreCase("taba") && loginrequest.getPassword().equalsIgnoreCase("abat")) {
			req.status(HttpStatus.BAD_REQUEST);
			
			 entity.put("output", "You are not authorised ");
		}
		else { 
			if (pubService.getPeopleByName(loginrequest.getEmail())) {
				 loginrequest.setToken(token);
				 entity.put("email", loginrequest.getEmail());
				 entity.put("token", token);
				req.status(HttpStatus.OK);
			}
			else {
					
				 entity.put("output", "Please register " );
				
				req.status(HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<Object>(entity, HttpStatus.OK);
		 
	}
	
	private String makeid(int length) {
		   String result           = "";
		   String characters       = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		   int  charactersLength = characters.length();
		   for (int i= 0; i < length; i++ ) {
		      result += characters.charAt((int)(Math.floor(Math.random() * charactersLength)));
		   }
		   return result;
		}
	
	
	
	
	
}
