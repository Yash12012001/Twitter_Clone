package com.twitter.DBInstance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.CommonLibrary.FollowRelationshipDTO.FollowReqBody;
import com.twitter.DBInstance.Service.FollowRelationshipDBSvc;

@RestController
@RequestMapping("/User-Follow-Operations")
public class FollowCntlr {
	
	@Autowired
	FollowRelationshipDBSvc service;
	
	@PostMapping("/Follow")
	public ResponseEntity<Object> FollowUser(@RequestBody FollowReqBody req){
		return service.insert(req);	
	}

}
