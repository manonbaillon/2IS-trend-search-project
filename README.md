# 2IS-trend-search-project
MIAGE 2IS web services project (april 2019)
  
  
## Client Part (React Js) 

- You have to make sure to have nodeJs installed in your computer. If you don't have it installed, you can download it online.
- Open the node Js command and access to your files using the CD command. (eg. cd C:\Users\Douglas Kamseu\Downloads\2IS MIAGE\S2\Web Services\trend-search)
- You can now type (npm start) in order to run the project
- The project will open on the browser using the URL http://localhost:3000
  
Note: (You have to make sure your server part is running on Netbeans)  
  
  
## Server Part (SpringBoot) 

- You have to first install MongoDB local and create a new database 
- You have to open the server code using Netbeans or Eclipse and edit the database connexion in the application.properties, example as follows:  
        # MongoDB  
        spring.data.mongodb.host     = localhost  
        spring.data.mongodb.port     = 27017  
        spring.data.mongodb.database = springboot-trendsearch  
- The default URL port is set as 8081. If you want, you can modify it in the application.yml
- Save all modifications, now you can run the project and test it using ReactJS or Postman
  
    
If you face any problem you can contact us.  
-Manon BAILLON, Andréa COTTAIS, Jean Paul Douglas KAMSEU MONGO-
