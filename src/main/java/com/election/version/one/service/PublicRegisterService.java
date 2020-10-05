package com.election.version.one.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.election.version.one.controller.Register;
import com.election.version.one.doman.People;
import com.election.version.one.repository.PeopleRepository;


@Service
public class PublicRegisterService {

	@Autowired  
	PeopleRepository peopleRepository;
	Logger logger = LoggerFactory.getLogger(PublicRegisterService.class);
	
	//getting all People records  
		public List<People> getAllpeople()   
		{  
		List<People> peoples = new ArrayList<People>();  
		  peopleRepository.findAll().forEach(People -> peoples.add(People));  
		return peoples;  
		}  
		
		public boolean getPeopleByName(String name)   
		{  
		List<People> peoples = new ArrayList<People>();  
		  peopleRepository.findAll().forEach(People -> peoples.add(People));  
		   List<People> fndList = peoples.stream().filter(p -> p.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		   System.out.println("getPeople  "+ fndList.size());
		   logger.info(" is registered  {}", name);
		  return fndList.size() ==0 ? false: true;  
		}  
		
		//getting a specific record  
		public People getpeopleById(int id)   
		{  
		  return peopleRepository.findById(id).get();  
		}  
		public void saveOrUpdate(People People)   
		{  
			peopleRepository.save(People);  
		}  
		//deleting a specific record  
		public void delete(int id)   
		{  
			peopleRepository.deleteById(id);  
		}  
}
