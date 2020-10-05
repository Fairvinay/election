package com.election.version.one.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.election.version.one.doman.People;

public class PublicRegister {

	Logger logger = LoggerFactory.getLogger(PublicRegister.class);
	
	 static String fileName = "people.json";
	 
	 int delay= 2000;
	 
	//Add people to list
     static JSONArray peopleList = new JSONArray();
     
	 static List<People> peoples = new ArrayList<People>();
	 
	 public void init () {
		 
		//JSON parser object to parse read file
	        JSONParser jsonParser = new JSONParser();
	        
	        ClassLoader classLoader = getClass().getClassLoader();
	        File file = new File(classLoader.getResource(fileName).getFile());
	         
	        BufferedInputStream is = new BufferedInputStream(getClass().getClassLoader().getResourceAsStream("people.json"));
	         
	      
	        try (FileReader reader = new FileReader(file))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	 
	             peopleList = (JSONArray) obj;
	            System.out.println(peopleList);
	            logger.info(" peopleList size ",peopleList.size());
	            //Iterate over people array
	            peopleList.forEach( people -> { peoples.add(parsePeople( (JSONObject) people )); } );
	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	 }
	 public void readTimely () {
		 
		 Timer timer = new Timer();
		 
		 timer.schedule(new TimerTask () {
			 @Override 
			 public void run() {
				init();
			 }
		 }, delay);
	 }
	 
	 public static String publicRegister ( String name, String voterZone) {
		 
		  String reg = "failed already registed name";
		  List<People> plAreadyReg = peoples.stream().filter( p -> 
			    
		  ((People)p).getName().equals(name) && ((People)p).getVoteZone().equals(voterZone) )
		  .collect(Collectors.toList());
		  
		  if (plAreadyReg.size() == 0 ) 
		  {  reg ="Welcome To Voting "+name+ "";
		     
		     People p =   new People ();
		     p.setName(name);
		     p.setVoteZone(voterZone);
		     writePeople(p);
		  }
		  
		  return reg;
		  
		 
	 } 
	 
	 private static boolean writePeople(People people) {
		   boolean process= false;
		   
		   ClassLoader classLoader = PublicRegister.class.getClassLoader();
	        File ft = new File(classLoader.getResource(fileName).getFile());
	      
	       
	        
		   //Write JSON file
	        try (FileWriter file = new FileWriter(ft)) {
	        	listFromPeopleArray(people);
	        	if(peopleList.size() > 0)
	        	{  file.write(peopleList.toJSONString());
	               file.flush();
	        	}
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		   
		   
		   return process;
		 
	 }
	 private static void listFromPeopleArray (People ppl) {
		 
		 //First People 
	        JSONObject peopleDetails = new JSONObject();
	        peopleDetails.put("name",  ppl.getName());
	        peopleDetails.put("voteZone", ppl.getVoteZone());
	        
	         
	        JSONObject peopleObject = new JSONObject(); 
	        peopleObject.put("people", peopleDetails);
	        
	        peopleList.add(peopleObject);
	 }
	 private static People parsePeople(JSONObject people) 
	    {
	        //Get People object within list
	        JSONObject peopleObject = (JSONObject) people.get("people");
	         
	        //Get People first name
	        String name = (String) peopleObject.get("name");    
	        System.out.println(name);
	         
	        //Get People last name
	        String voteZone = (String) peopleObject.get("voteZone");  
	        System.out.println(voteZone);
	         
	        
	        People nPeop = new People();
	        
	        
	        nPeop.setName(name); 
	        nPeop.setVoteZone(voteZone);
	        
	        return nPeop;
	        
	    }
		
}
