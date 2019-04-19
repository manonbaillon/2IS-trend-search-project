package com.miage.trendsearch.service;

import com.miage.trendsearch.DAO.TumblrAPI;
import java.util.List;
import org.springframework.social.facebook.api.Post;

public class TumblrService {
    private TumblrAPI tumblrAPI = new TumblrAPI();
   
    public List<String> getPosts(String keyword){
        return tumblrAPI.getPosts(keyword);
    }
    
    //STATISTICS HERE!!!!
}
