package com.election.version.one.doman;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Candidates { 
	
	public Candidates [] candidates; 
	
	public static void main (String[] args) {
		
		// JSON parser 
	}
	public List<Candidate> parseCandidates() {
		
		List candidates = new ArrayList<>();
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        
        InputStream is = getClass().getClassLoader().getResourceAsStream("candidates.json");
        
        try (FileReader reader = new FileReader("candidates.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray candidateList = (JSONArray) obj;
            System.out.println(candidateList);
             
            //Iterate over candidate array
            candidateList.forEach( candidate -> { candidates.add(parseCandidate( (JSONObject) candidate )); } );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return candidates;  
	}
	
	private static Candidate parseCandidate(JSONObject candiate) 
    {
        //Get candidate object within list
        JSONObject candiateObject = (JSONObject) candiate.get("candidate");
         
        //Get candidate first name
        String firstname = (String) candiateObject.get("firstName");    
        System.out.println(firstname);
         
        //Get candidate last name
        String surname = (String) candiateObject.get("surname");  
        System.out.println(surname);
         
        //Get candidate cadidateid name
        String cadidateid = (String) candiateObject.get("cadidateid");  
        
        System.out.println(cadidateid);
        
        //Get candidate votezone name
        String votezone = (String) candiateObject.get("votezone");  
      
        System.out.println(votezone);
        
        //Get candidate birthdate name
        String birthdate = (String) candiateObject.get("birthdate");  
        
        System.out.println(cadidateid);
        
        Candidate nCand = new Candidate();
        
        nCand.setBirthdate(birthdate);
        nCand.setCadidateid(Integer.parseInt(cadidateid));
        nCand.setFirstname(firstname);
        nCand.setSurname(surname);
        nCand.setVotezone(votezone);
        
        return nCand;
        
    }
	
	
	
	
	
	
}
