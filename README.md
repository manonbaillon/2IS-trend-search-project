# 2IS-trend-search-project
MIAGE 2IS web services project (april 2019)

- Manon BAILLON, Andréa COTTAIS, Jean Paul Douglas KAMSEU MONGO -


----------------------------------
----- Client Part (React Js) -----
----------------------------------
- You have to make sure to have nodeJs installed in your computer. If you don't have it installed, you can download it online.
- Open the node Js command and access to your files using the CD command. (eg. cd C:\Users\Douglas Kamseu\Downloads\2IS MIAGE\S2\Web Services\trend-search)
- You can now type (npm start) in order to run the project
- The project will open on the browser using the URL http://localhost:3000

Note: (You have to make sure your server part is running on Netbeans)

----------------------------------
---- Server Part (SpringBoot) ----
----------------------------------
- You have to first install MongoDB local and create a new database 
- You have to open the server code using Netbeans or Eclipse and edit the connexion in the application.properties, as follows:
        # MongoDB
        spring.data.mongodb.host     = localhost
        spring.data.mongodb.port     = 27017
        spring.data.mongodb.database = springboot-trendsearch

- Save it and now you can run the project and test it using ReactJS or Postman
