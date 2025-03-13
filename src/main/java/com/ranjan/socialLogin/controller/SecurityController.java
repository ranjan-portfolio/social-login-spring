package com.ranjan.socialLogin.controller;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SecurityController {

    @GetMapping("/secure")
    public String getSecureLogin(Authentication authentication){
        if(authentication instanceof UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken){
            System.out.println("this is username and password authentication block"+usernamePasswordAuthenticationToken);
        }

        if(authentication instanceof OAuth2AuthenticationToken oAuth2AuthenticationToken){
            System.out.println("Inside Oauth2AuthenticationToken"+oAuth2AuthenticationToken);
            
        }

        return "secure.html";
    }
    
}
