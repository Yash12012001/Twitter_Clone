package com.twitter.LoginSignUp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan({"com.twitter.DBInstance"})
public class LoginSignUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginSignUpApplication.class, args);
	}
	

	
	

}
