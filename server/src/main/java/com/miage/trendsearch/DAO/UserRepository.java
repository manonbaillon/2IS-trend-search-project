package com.miage.trendsearch.DAO;

import com.miage.trendsearch.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
 
public interface UserRepository extends MongoRepository<User, String>{
    public User findById(ObjectId id);
    public User findByEmail(String email);
}
