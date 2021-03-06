    DROP TABLE IF EXISTS PEOPLE;  
    CREATE TABLE PEOPLE (  
    PEOPLE_CODE INT AUTO_INCREMENT  PRIMARY KEY,  
    NAME VARCHAR(50) NOT NULL,  
    VOTEZONE VARCHAR(50) NOT NULL
    );  
    DROP TABLE IF EXISTS CANDIDATE;  
     CREATE TABLE CANDIDATE(  
    CADIDATEID INT AUTO_INCREMENT  PRIMARY KEY,  
    FIRSTNAME VARCHAR(50) NOT NULL,
    SURNAME VARCHAR(50) NOT NULL,
    BIRTHDATE  DATE,
    VOTEZONE VARCHAR(50) NOT NULL,
    SYMBOL VARCHAR(40) NOT NULL
    );
     DROP TABLE IF EXISTS BALLOT;  
     CREATE TABLE BALLOT(  
    VOTEID INT AUTO_INCREMENT  PRIMARY KEY,  
    VOTECADIDATEID INT NOT NULL,
    NAME VARCHAR(50) NOT NULL,
   
    VOTEZONE VARCHAR(50) NOT NULL
   
    ); 
     DROP TABLE IF EXISTS VOTE; 
    CREATE TABLE VOTE (  
    VOTEID INT AUTO_INCREMENT  PRIMARY KEY,  
    VOTECADIDATEID INT NOT NULL,
    VOTEZONE VARCHAR(50) NOT NULL
    ); 
    DROP TABLE IF EXISTS VOTEZONERESULT; 
    CREATE TABLE VOTEZONERESULT (  
    COUNT INT ,  
    VOTECADIDATEID INT NOT NULL,
    VOTEZONE VARCHAR(50) 
    ); 
     
     