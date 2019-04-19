package com.miage.trendsearch.service;

import com.miage.trendsearch.DAO.UserRepository;
import com.miage.trendsearch.model.User;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
  
    // Authenticate user
    public boolean authenticateUser(String email, String password){
        User storredUser = userRepository.findByEmail(email);
        
        if (storredUser.getPassword().equals(password)){
            return true;
        }
        return false;
    }
    
    // Get all users
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    
    // Get a user by its ID
    public User getUserByID(ObjectId id){
        return userRepository.findById(id);
    }
    
    // Check if a user with a mail already exists
    public boolean isUserExist(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null){
            return true;
        }
        return false;      
    }
        
    // Create a new user    
    public User createUser(User user) {
        user.setId(ObjectId.get());
        userRepository.save(user);
        return user;
    }
    
    // Update the password of a user    
    public void updateUserByID(ObjectId id, User user) {
      // if (userRepository.findByEmail(user.getEmail()) == null){
        user.setId(id);
        userRepository.save(user);
      // }
    }
    
    // Delete a user by its ID
    public void deleteUserById(ObjectId id) {
        userRepository.deleteById(id.toHexString());
    }
    
    // Update the list of keywords
    public void updateListOfKeywords(User user, String keyword) {
        user.getListOfKeywords().add(keyword) ;
        userRepository.save(user);
    }
}
