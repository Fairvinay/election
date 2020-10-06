package com.election.version.one;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.election.version.one.service.VoteService;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
//@SpringBootTest
// http://zetcode.com/springboot/testentitymanager/
@ContextConfiguration(classes=com.election.version.one.config.TestConfig.class)
@TestPropertySource(locations= "classpath:application-test.properties")
@DataJpaTest
public class BallotTest {

    
	 @Autowired
	    private TestEntityManager entityManager;
	
     @Autowired
     private VoteService voteService;

     @Test
     public void addNewVote() {
         System.out.println("addNewVote()...");  // <-- This prints in the console
         final String email = "test@test.io";
         String votecandidateid = "2";
         String  voteid = "1";
         String votezone ="Kharadi"; 
         String name = "Tejas";
         boolean vote  = voteService.castVote(votecandidateid ,voteid,votezone,name);  // <-- We get an exception in here...
         
         assertThat(vote).isTrue();
         
         
         
     }  
}