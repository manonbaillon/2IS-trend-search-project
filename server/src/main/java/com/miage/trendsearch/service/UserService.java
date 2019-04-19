package com.miage.trendsearch.service;

import com.miage.trendsearch.model.User;
import java.util.List;
import org.bson.types.ObjectId;

public interface UserService {
    List<User> getAllUser();
    User getUserByID(ObjectId id);
    User createUser(User user);
    boolean authenticateUser(String email, String password);
    boolean isUserExist(User user);
    void updateUserByID(ObjectId id, User user);
    void deleteUserById(ObjectId id);
    void updateListOfKeywords(User user, String keyword);
}
