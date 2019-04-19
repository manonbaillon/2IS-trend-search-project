package com.miage.trendsearch.service;

import com.miage.trendsearch.DAO.TwitterAPI;
import java.util.List;
import org.springframework.social.twitter.api.Tweet;

public class TwitterService {
    final private TwitterAPI twitterAPI = new TwitterAPI();
    
    private int totalLike;
    private int totalShared;
    
    public List<Tweet> getTweets(String keyword){
        return twitterAPI.getTweets(keyword);
    }

    // GETTER AND SETTER
    public int getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(int totalLike) {
        this.totalLike = totalLike;
    }

    public int getTotalShared() {
        return totalShared;
    }

    public void setTotalShared(int totalShared) {
        this.totalShared = totalShared;
    }
    
    
    
    //---------------  STATISTICS  ---------------//
    public int getTotalLike(String keyword){
        List<Tweet> listOfTweets = twitterAPI.getTweets(keyword);
        totalLike = 0;
        
        for (Tweet tweet : listOfTweets) {
            totalLike = totalLike + tweet.getFavoriteCount();
        }
        return totalLike;
    }
    
    public int getTotalShared(String keyword){
        List<Tweet> listOfTweets = twitterAPI.getTweets(keyword);
        totalShared = 0;
        
        for (Tweet tweet : listOfTweets) {
            totalShared = totalShared + tweet.getRetweetCount();
        }
        return totalShared;
    }
            
    public int getAvgLike(String keyword){
        List<Tweet> listOfTweets = twitterAPI.getTweets(keyword);
        return getTotalLike()/listOfTweets.size() ;
    }                   
    
    public int getAvgShared(String keyword){
        List<Tweet> listOfTweets = twitterAPI.getTweets(keyword);
        return getTotalShared()/listOfTweets.size() ;
    }
    
    public double getPercentHashtag(String keyword){
        List<Tweet> listOfTweets = twitterAPI.getTweets(keyword);
        double nbContainHashtag = 0;
        
        for (Tweet tweet : listOfTweets) {
            if (tweet.hasTags()){
                nbContainHashtag++ ;
            }       
        }
        return (double)Math.round((nbContainHashtag/listOfTweets.size()*100) * 100) / 100;
    }
    
        public double getPercentMedia(String keyword){
        List<Tweet> listOfTweets = twitterAPI.getTweets(keyword);
        double nbContainMedia = 0;
        
        for (Tweet tweet : listOfTweets) {
            if (tweet.hasMedia()){
                nbContainMedia++ ;
            }       
        }
        return (double)Math.round((nbContainMedia/listOfTweets.size()*100) * 100) / 100;
    }
        
    public double getPercentRetweet(String keyword){
        List<Tweet> listOfTweets = twitterAPI.getTweets(keyword);
        double nbRetweet = 0;
        
        for (Tweet tweet : listOfTweets) {
            if (tweet.isRetweeted()){
                nbRetweet++ ;
            }       
        }
        return (double)Math.round((nbRetweet/listOfTweets.size()*100) * 100) / 100;
    }
}
