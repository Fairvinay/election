package com.election.version.one;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
import com.election.version.one.service.CandidateRegister;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
//@SpringBootTest
// http://zetcode.com/springboot/testentitymanager/
@ContextConfiguration(classes=com.election.version.one.config.TestConfig.class)
@TestPropertySource(locations= "classpath:application-test.properties")
@DataJpaTest
public class DuplicateCandidateTest {

    
	 @Autowired
	    private TestEntityManager entityManager;
	
     @Autowired
     private CandidateRegister candService;
     
     @Before
     public void setUp() throws ParseException {
    	 
    	 final String email = "test@test.io";
         String votecandidateid = "2";
         String  voteid = "1";
         String votezone ="Kharadi"; 
         String name = "Tejas";
         /* 
          double highestAvg = Arrays.stream(scores)
           .collect(groupingBy(s -> s[0],
                               averagingInt(s -> parseInt(s[1]))))
           .values()
           .stream()
           .max(naturalOrder())
           .get();

          */
         Candidate [] candidates = { new  Candidate("01-05-2010" , "1", "tejas", "khanna", "u2342","2"), 
 				new  Candidate("01-05-2010" , "2", "tejas", "khanna", "u2342","2"),
 				new  Candidate("02-05-2000" , "3", "Veram", "Shamra", "u2322","1"),
 	new  Candidate("02-11-1997" , "4", "Sagar", "Samule", "u2311","2"),
 new  Candidate("01-09-2003" , "5", "Umeshr", "Dekan", "u2309","1")
 					};

         
         Arrays.stream(candidates)
         .forEach(x ->  candService.saveOrUpdate(x));
         
        
       // <-- We get an exception in here...
         
     }


     @Test
     public void testDuplicateCandidate() {
    	 
    	 System.out.println("testDuplicateCandidate()...");  // <-- This prints in the console
         
        List <Candidate> cdList = candService.getAllCandidate() ;
        // <-- We get an exception in here...
        
        cdList.sort(Comparator.comparing(i-> ((Candidate)i).getFirstname()).thenComparing(i-> ((Candidate)i).getSurname())
        		.thenComparing(i-> ((Candidate)i).getBirthdate()).thenComparing(i-> ((Candidate)i).getVotezone())
        		
        		);
         
        assertTrue(cdList.size() > 1);
     
     
     }
     
     
     
     
     
     
}