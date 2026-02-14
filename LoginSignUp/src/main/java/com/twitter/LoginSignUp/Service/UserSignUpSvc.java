package com.twitter.LoginSignUp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.twitter.CommonLibrary.InsertUserDTO.InsertUserDataReqBody;
import com.twitter.LoginSignUp.FeignClient.FeignClient;
import com.twitter.LoginSignUp.Security.TwitterPasswordEncoder;

@Service
public class UserSignUpSvc {
	
	@Autowired
	FeignClient client;
	
	@Autowired 
	private TwitterPasswordEncoder encoder;
	
	public ResponseEntity<Object> createUser(InsertUserDataReqBody req){
		String rawPassword = req.getPassword();
		req.setPassword(encoder.encode(rawPassword));
		return client.insertUserData(req);
	}
	
	

}
