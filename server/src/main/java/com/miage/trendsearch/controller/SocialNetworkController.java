package com.miage.trendsearch.controller;

import com.miage.trendsearch.service.FacebookService;
import com.miage.trendsearch.service.RedditService;
import com.miage.trendsearch.service.TumblrService;
import com.miage.trendsearch.service.TwitterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    
    // GENERAL TREND
    public ResponseEntity getTweets(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>("ERROR. PART NOT DEVELOPED YET", HttpStatus.NOT_FOUND);
    }
    
    // SOCIAL NETWORK TREND
    @GetMapping("/{socialNetwork}")
    @CrossOrigin(origins = "http://localhost:3000/")
    
    public ResponseEntity getPosts(@RequestParam(value="keyword", required=true) String keyword, 
            @PathVariable(value="socialNetwork", required=false) String socialNetwork) {
        
        if(socialNetwork.equalsIgnoreCase(TWITTER)){
            return new ResponseEntity<>(twitterService.getTweets(keyword), HttpStatus.OK);
        } 
        else if (socialNetwork.equalsIgnoreCase(FACEBOOK)){
            return new ResponseEntity<>(facebookService.getPosts(keyword), HttpStatus.OK);
            //return new ResponseEntity<>(facebookService.getPosts(keyword), HttpStatus.OK);
        }
        else if (socialNetwork.equalsIgnoreCase(REDDIT)){
            return new ResponseEntity<>(redditService.getPosts(keyword), HttpStatus.OK);
        }
        else if (socialNetwork.equalsIgnoreCase(TUMBLR)){
            return new ResponseEntity<>(tumblrService.getPosts(keyword), HttpStatus.OK);
        }
        return new ResponseEntity<>("Social network not found.", HttpStatus.NOT_FOUND);
    }
    
    // TWITTER STATISTICS
    @GetMapping("/{socialNetwork}/totalLike")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getTotalLike(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getTotalLike(keyword), HttpStatus.OK);
    }
    
    @GetMapping("/{socialNetwork}/totalShared")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getTotalShared(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getTotalShared(keyword), HttpStatus.OK);
    }
  
    @GetMapping("/{socialNetwork}/avgLike")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getAvgLike(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getAvgLike(keyword), HttpStatus.OK);
    }

    @GetMapping("/{socialNetwork}/avgShared")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getAvgShared(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getAvgShared(keyword), HttpStatus.OK);
    }
    
    @GetMapping("/{socialNetwork}/percentRetweet")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getPercentRetweet(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getPercentRetweet(keyword), HttpStatus.OK);
    }
    
    @GetMapping("/{socialNetwork}/percentHashtag")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getPercentHashtag(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getPercentHashtag(keyword), HttpStatus.OK);
    }
    
    @GetMapping("/{socialNetwork}/percentMedia")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity getPercentMedia(@RequestParam(value="keyword", required=true) String keyword) {
        return new ResponseEntity<>(twitterService.getPercentMedia(keyword), HttpStatus.OK);
    }

}
