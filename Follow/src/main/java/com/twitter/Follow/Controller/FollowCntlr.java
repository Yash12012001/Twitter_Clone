package com.twitter.Follow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.Follow.Model.FollowUnFollowReqBody;
import com.twitter.Follow.Service.FollowSvc;

@RestController
@RequestMapping("/TwiterClone/Follow")
public class FollowCntlr {
	
	@Autowired
	private FollowSvc service;
	
	@PostMapping
	public ResponseEntity<Object> followUser(@RequestBody FollowUnFollowReqBody req){
		return service.followUser(req);
	}
	
	
	

}
