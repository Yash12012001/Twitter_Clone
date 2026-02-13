package com.twitter.LoginSignUp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.LoginSignUp.Model.UserLoginReqBody;
import com.twitter.LoginSignUp.Service.UserLoginSvc;

@RestController
@RequestMapping("/TwiterClone/Login")
public class LoginCntlr {
	
	@Autowired
	UserLoginSvc service;
	
	@PostMapping
	public ResponseEntity<Object> UserLogin(@RequestBody UserLoginReqBody req){
		return service.userLogin(req);
	}
	
	

}
