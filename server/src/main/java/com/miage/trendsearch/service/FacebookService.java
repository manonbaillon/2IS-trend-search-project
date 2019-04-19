package com.miage.trendsearch.service;

import com.miage.trendsearch.DAO.FacebookAPI;
import java.util.List;
import org.springframework.social.facebook.api.Post;

public class FacebookService {
    private FacebookAPI facebookAPI = new FacebookAPI();
   
    public List<Post> getPosts(String keyword){
        return facebookAPI.getPosts(keyword);
    }
    
    //STATISTICS HERE!!!!
}
