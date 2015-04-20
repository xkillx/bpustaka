#Build database and Run
1. we preparing database

    a. create user access to database
      
      grant all on bpustaka.* to bpustaka@localhost identified by 'bpustaka';
      
    b. create database
    
        create database bpustaka
        
2. Resource Server

    a. change to direktory rest-api
    
        cd /rest-api
        
    b. Run spring-boot (on terminal)
    
        mvn clean spring-boot:run
        
    c. put url on browser
    
        localhost:10000/api/
