package com.election.version.one;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.election.version.one.doman.Candidate;
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
     
     @Before
     public void setUp() {
    	 
    	 final String email = "test@test.io";
         String votecandidateid = "2";
         String  voteid = "1";
         String votezone ="Kharadi"; 
         String name = "Tejas";
       // add more votes 
       String [][] ballVotes = {{ "1", "7"  , "Kharadi", "Tejas" },
    		   			      { "2" , "8"  , "Maggarpatta" , "Fridaus"},
    		   			      { "2" , "9" , "Maggarpatta" , "Bracus"},
    		   			      { "2" , "10" , "Maggarpatta" , "Tallus"},
    		   			      { "2" , "10" , "Kharadi" , "Morbi"}
       						} ;
     Function <String [] , Integer > function  = new Function<String[], Integer>() {
    	 @Override
		public Integer apply(String[] t) {
    		 boolean vote =voteService.castVote(t[0] ,t[1],t[2],t[3]); 
    		return vote ? 0:-1;
		}
    	  
      };
      Arrays.stream(ballVotes).map(function);
        // boolean vote  = voteService.checkVoteAlreadyDone(votecandidateid ,voteid,votezone,name);  
      }
  
     @Test
     public void addNewVote() {
         System.out.println("addNewVote()...");  // <-- This prints in the console
         final String email = "test@test.io";
         String votecandidateid = "2";
         String  voteid = "2";
         String votezone ="Kharadi"; 
         String name = "Rajehs";
         boolean vote  = voteService.castVote(votecandidateid ,voteid,votezone,name);  // <-- We get an exception in here...
         
         assertThat(vote).isTrue();
         
     }  
     @Test
     public void testDuplicateVote() {
    	 
    	 System.out.println("testDuplicateVote()...");  // <-- This prints in the console
         final String email = "test@test.io";
         String votecandidateid = "2";
         String  voteid = "1";
         String votezone ="Kharadi"; 
         String name = "Tejas";
         boolean vote  = voteService.checkVoteAlreadyDone(votecandidateid ,voteid,votezone,name);  // <-- We get an exception in here...
         
         assertThat(vote).isTrue();
     }
     @Test 
     public void countWinner() {
    	  
    	 Candidate cd  =  voteService.winnerBallot();
    	 System.out.println(" Winneer Candidate "+cd);
    	 
     }
     
     
}