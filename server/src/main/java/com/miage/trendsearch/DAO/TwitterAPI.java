package com.miage.trendsearch.DAO;

import com.miage.trendsearch.utils.Constantes;
import java.util.List;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

public class TwitterAPI {
    // Connect to Twitter API using login and password
    Twitter twitter = new TwitterTemplate(Constantes.CONSUMERKEY, Constantes.CONSUMERSECRET, Constantes.ACCESSTOKEN, Constantes.ACCESSTOKEN_SECRET);
    //Twitter twitter = new TwitterTemplate(prop.getProperty("CONSUMERKEY"), prop.getProperty("CONSUMERSECRET"), prop.getProperty("ACCESSTOKEN"), prop.getProperty("ACCESSTOKEN_SECRET"));
    TwitterProfile profile = twitter.userOperations().getUserProfile();
    
    // Get the list of tweets
    public List <Tweet> getTweets(String keyword){
        SearchResults results = twitter.searchOperations().search(keyword, 100);
        return results.getTweets();
    }
}
