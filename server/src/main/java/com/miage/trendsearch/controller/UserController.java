package com.miage.trendsearch.controller;

import com.miage.trendsearch.model.User;
import com.miage.trendsearch.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
        UserService userService;
         
    //------------------------- [POST] - login user ----------------------------------------
    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000/")
    public String loginUser(@Valid @RequestBody User user ) {
       if (userService.authenticateUser(user.getEmail(), user.getPassword()) == true) {
           return "Authentification succceed";
       }
       
       else {
           return "Authentification failed";
       }
   } 
      
    /*
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser( @Valid @RequestBody User user) {
        if (userService.authenticateUser(user.getEmail(), user.getPassword())){
            return new ResponseEntity("Authentification succeed", HttpStatus.OK);
        }
        return new ResponseEntity("Authentification failed", HttpStatus.NOT_FOUND);
    }
    */
   
    //------------------------- [GET] - get all users  ----------------------------------------
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
            List<User> users = userService.getAllUser();
            if (users.isEmpty()) {
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    //------------------------- [GET] - get user by ID  ----------------------------------------
    @RequestMapping(value="/users/{userID}", method=RequestMethod.GET)
    public ResponseEntity<?> getUserByID(@PathVariable("userID") ObjectId id){
        User user = userService.getUserByID(id);
        if (user == null){
                return new ResponseEntity("User with id " + id  + " not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //------------------------ [POST] -- add new user - fn : createUser()-------------------
    @RequestMapping(value="/users", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user){
        if(userService.isUserExist(user)){
            return new ResponseEntity("Unable to create a user with email " + user.getEmail()  + ". It already exists", HttpStatus.CONFLICT);
        }
        userService.createUser(user);
        
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    //------------------------- [PUT] - update user - fn : updateUserByID() ---------------------
    @RequestMapping(value="/users/{userID}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("userID") ObjectId id, @Valid @RequestBody User user){
        User currentUser = userService.getUserByID(id);
        
        if (!userService.isUserExist(user)){
            return new ResponseEntity("User with email " + user.getEmail()  + " not found. Unable to update.", HttpStatus.NOT_FOUND);
        }
        
        else if (!currentUser.getEmail().equals(user.getEmail())){
            return new ResponseEntity("The email " + user.getEmail()  + " is not associated to this user. Unable to update.", HttpStatus.NOT_FOUND);
        }
        
        userService.updateUserByID(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //------------------------- [DELETE] - delete user by ID - fn : deleteUserByID() ---------------------
    @RequestMapping(value="/users/{userID}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("userID") ObjectId id){
        
        userService.deleteUserById(id);
        return new ResponseEntity<>("User with id " + id + " deleted.", HttpStatus.NO_CONTENT);
    }  
    
    //------------------------- [PUT] - update list of keywords - fn : updateListOfKeywords() ---------------------
        @RequestMapping(value="/users/historic/{userID}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateListOfKeywords(@PathVariable("userID") ObjectId id, @RequestParam(value="keyword", required=true) String keyword){
        
        User user = userService.getUserByID(id);
        if (!userService.isUserExist(user)){
            return new ResponseEntity("User with email " + user.getEmail()  + " not found.", HttpStatus.NOT_FOUND);
        }   

        userService.updateListOfKeywords(user, keyword);
        return new ResponseEntity<>("User saved keywords: " + user.getListOfKeywords(), HttpStatus.OK);
    }
}

 