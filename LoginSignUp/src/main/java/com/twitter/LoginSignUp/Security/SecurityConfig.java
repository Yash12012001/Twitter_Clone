package com.twitter.LoginSignUp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain secFilterChain(HttpSecurity http) {
		http.csrf(csrf-> csrf.disable())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(request -> request.requestMatchers("/TwiterClone/SignUp","/TwiterClone/Login").permitAll()
													.anyRequest().authenticated());
		
		
		return http.build();
		
	}
	
	@Bean
	 public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration config) throws Exception {
	      return config.getAuthenticationManager();
	}  

}
