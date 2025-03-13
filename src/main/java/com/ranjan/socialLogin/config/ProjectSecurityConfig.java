package com.ranjan.socialLogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity secure) throws Exception{

        secure.authorizeHttpRequests((request)->
            request.requestMatchers("/secure").authenticated()
            .anyRequest().permitAll())
            .formLogin(Customizer.withDefaults())
            .oauth2Login(Customizer.withDefaults());
        
            return secure.build();
    }
@Bean
    ClientRegistrationRepository clientRegistrationRepository(){

        ClientRegistration githubClientRegistration=githubClientRegistration();
        ClientRegistration facebookClientRegistration=facebookClientRegistration();

        return new InMemoryClientRegistrationRepository(githubClientRegistration,facebookClientRegistration);
    }
    private ClientRegistration githubClientRegistration(){
       return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("Ov23livWzHnK52AJhVqH").clientSecret("b80fb302cc60a83397942de06284fd8077a199fb").build();
    }
    private ClientRegistration facebookClientRegistration(){
        return CommonOAuth2Provider.FACEBOOK.getBuilder("facebook").clientId("366195979888436").clientSecret("8d30c3de9cb530833c6ff1cbe3699aa9").build();
     }
    
}
