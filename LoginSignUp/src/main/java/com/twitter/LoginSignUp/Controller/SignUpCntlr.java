package com.twitter.LoginSignUp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.CommonLibrary.InsertUserDTO.InsertUserDataReqBody;
import com.twitter.LoginSignUp.Service.UserSignUpSvc;


@RestController
@RequestMapping("/TwiterClone/SignUp")
public class SignUpCntlr {
	@Autowired
	private UserSignUpSvc service;
	
	
	
	@PostMapping
	public ResponseEntity<Object> UserSignUp(@RequestBody InsertUserDataReqBody req){
		
		System.out.println("reached");
		
		return service.createUser(req);
	}

}
