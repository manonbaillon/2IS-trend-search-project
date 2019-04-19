package com.miage.trendsearch.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;


public class User {
    
    @Id
    private ObjectId id;
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<String> listOfKeywords = new ArrayList<>();
    
    // Constructor
    public User() {}
    
    public User(ObjectId id, String firstName, String lastName, String email, String password, List<String> listOfKeywords) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.listOfKeywords = listOfKeywords;
    }

    // Getter and setter
    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getListOfKeywords() {
        return listOfKeywords;
    }

    public void setListOfKeywords(List<String> listOfKeywords) {
        this.listOfKeywords = listOfKeywords;
    }

    @Override
    public String toString() {
        return String.format(
            "User[id=%s, firstName=%s, lastName=%s, email=%s, password=%s, Keywords=%s]",
            id, firstName, lastName, email, password, listOfKeywords);
    } 
}
