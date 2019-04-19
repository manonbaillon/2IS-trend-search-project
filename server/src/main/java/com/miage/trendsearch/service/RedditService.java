package com.miage.trendsearch.service;

import com.miage.trendsearch.DAO.RedditAPI;
import java.util.List;
import org.springframework.social.facebook.api.Post;

public class RedditService {
    private RedditAPI redditAPI = new RedditAPI();
   
    public List<String> getPosts(String keyword){
        return redditAPI.getPosts(keyword);
    }
    
    //STATISTICS HERE!!!!
}
