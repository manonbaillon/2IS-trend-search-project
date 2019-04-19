package com.miage.trendsearch.controller;

import com.miage.trendsearch.service.FacebookService;
import com.miage.trendsearch.service.RedditService;
import com.miage.trendsearch.service.TumblrService;
import com.miage.trendsearch.service.TwitterService;
import com.miage.trendsearch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trend")
public class SocialNetworkController {    
    final static String FACEBOOK = "facebook";
    final static String TWITTER  = "twitter";
    final static String REDDIT   = "reddit";
    final static String TUMBLR   = "tumblr";
    
    private final TwitterService twitterService = new TwitterService();
    private final FacebookService facebookService = new FacebookService();
    private final RedditService redditService = new RedditService();
    private final TumblrService tumblrService = new TumblrService();
    
    @Autowired
    private UserService userService;
    
    // GENERAL TREND
    public ResponseEntity getTweets(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>("ERROR. PART NOT DEVELOPED YET", HttpStatus.NOT_FOUND);
    }
    
    // SOCIAL NETWORK TREND
    @RequestMapping("/{socialNetwork}")
	@CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getPosts(@RequestParam(value="keyword", required=true) String keyword, 
            @PathVariable(value="socialNetwork", required=false) String socialNetwork) {
        
        if(socialNetwork.equalsIgnoreCase(TWITTER)){
           // userService.updateListOfKeywords(user, keyword);
            return new ResponseEntity<>(twitterService.getTweets(keyword), HttpStatus.OK);
        } 
        else if (socialNetwork.equalsIgnoreCase(FACEBOOK)){
            return new ResponseEntity<>(facebookService.getPosts(keyword), HttpStatus.OK);
            //return new ResponseEntity("Error. Facebook not found, the information is no more available.", HttpStatus.NOT_FOUND);
        }
        else if (socialNetwork.equalsIgnoreCase(REDDIT)){
            return new ResponseEntity<>(redditService.getPosts(keyword), HttpStatus.OK);
            //return new ResponseEntity("Error. Reddit not found, the information is not available.", HttpStatus.NOT_FOUND);
        }
        else if (socialNetwork.equalsIgnoreCase(TUMBLR)){
            return new ResponseEntity<>(tumblrService.getPosts(keyword), HttpStatus.OK);
            //return new ResponseEntity("Error. Tumblr not found, the information is not available.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Social network not found.", HttpStatus.NOT_FOUND);
    }
    
    // TWITTER STATISTICS
    @RequestMapping("/{socialNetwork}/totalLike")
	@CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getTotalLike(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getTotalLike(keyword), HttpStatus.OK);
    }
    
    @RequestMapping("/{socialNetwork}/totalShared")
	@CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getTotalShared(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getTotalShared(keyword), HttpStatus.OK);
    }
  
    @RequestMapping("/{socialNetwork}/avgLike")
	@CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getAvgLike(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getAvgLike(keyword), HttpStatus.OK);
    }

    @RequestMapping("/{socialNetwork}/avgShared")
	@CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getAvgShared(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getAvgShared(keyword), HttpStatus.OK);
    }
    
    @RequestMapping("/{socialNetwork}/percentRetweet")
	@CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getPercentRetweet(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getPercentRetweet(keyword), HttpStatus.OK);
    }
    
    @RequestMapping("/{socialNetwork}/percentHashtag")
	@CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getPercentHashtag(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getPercentHashtag(keyword), HttpStatus.OK);
    }
    
    @RequestMapping("/{socialNetwork}/percentMedia")
	@CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getPercentMedia(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getPercentMedia(keyword), HttpStatus.OK);
    }
}
