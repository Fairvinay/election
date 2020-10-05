INSERT INTO PEOPLE VALUES (1,'Brian', 'Maggarpatta');  
 
INSERT INTO CANDIDATE VALUES (1,'Prita', 'Kelkar',parsedatetime('18-02-1995','dd-MM-yyyy') ,'Kharadi', 'U+270B');  

INSERT INTO CANDIDATE VALUES (2,'Sagar', 'Basic',parsedatetime('18-02-2001','dd-MM-yyyy') ,'Maggarpatta', 'U+234B');  

INSERT INTO CANDIDATE VALUES (3,'Samuel', 'Kathat',parsedatetime('18-02-2005','dd-MM-yyyy') ,'Maggarpatta', 'U+234B');  

INSERT INTO BALLOT VALUES (1, 1, 'Prita','Kharadi');
INSERT INTO BALLOT VALUES (2, 1, 'Prita','Kharadi');
INSERT INTO BALLOT VALUES (3, 2, 'Sagar','Maggarpatta');
INSERT INTO BALLOT VALUES (4, 2, 'Sagar','Maggarpatta');
INSERT INTO BALLOT VALUES (5, 2, 'Sagar','Maggarpatta');
INSERT INTO BALLOT VALUES (6, 1, 'Prita','Kharadi');
--INSERT INTO VOTE VALUES ( 1 ,'22' , 'Maggarpatta');
