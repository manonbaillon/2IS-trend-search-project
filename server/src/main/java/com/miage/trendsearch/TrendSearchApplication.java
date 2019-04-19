package com.miage.trendsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class TrendSearchApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TrendSearchApplication.class,args);
       
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
       return new WebMvcConfigurerAdapter() {
          @Override
          public void addCorsMappings(CorsRegistry registry) {
             registry.addMapping("/trend/{socialNetwork}").allowedOrigins("http://localhost:3000");
             registry.addMapping("/trend/{socialNetwork}/totalLike").allowedOrigins("http://localhost:3000");
             registry.addMapping("/trend/{socialNetwork}/totalShared").allowedOrigins("http://localhost:3000");
             registry.addMapping("/trend/{socialNetwork}/percentRetweet").allowedOrigins("http://localhost:3000");
             registry.addMapping("/trend/{socialNetwork}/percentHashtag").allowedOrigins("http://localhost:3000");
             registry.addMapping("/trend/{socialNetwork}/percentMedia").allowedOrigins("http://localhost:3000");
             registry.addMapping("/loginUser").allowedOrigins("http://localhost:3000");

    }
      };
   }
}
