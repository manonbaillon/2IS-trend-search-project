package com.miage.trendsearch.DAO;

import java.util.ArrayList;
import java.util.List;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

public class FacebookAPI {
        //--------------------------------------------------------------------
        //------------------------- WORK IN PROGRESS -------------------------
        //--------------------------------------------------------------------

        // Connect to Facebook API using login and password
        //Facebook facebook = new FacebookTemplate(, );
        //FacebookProfile profile = facebook.userOperations().getUserProfile();

        // Get the list of tweets
        public List <Post> getPosts(String keyword){
            List test = new ArrayList();
            return test;
        }
}

