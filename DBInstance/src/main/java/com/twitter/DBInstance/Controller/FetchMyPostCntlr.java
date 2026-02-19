package com.twitter.DBInstance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.CommonLibrary.FetchMyPostDTO.FetchMyPostReqBody;
import com.twitter.CommonLibrary.FetchMyPostDTO.FetchMyPostResBody;
import com.twitter.DBInstance.Service.FetchContentDbSvc;

@RestController
@RequestMapping("User-Fetch-My-Post")
public class FetchMyPostCntlr {
	
	@Autowired
	FetchContentDbSvc service;
	
	@PostMapping
	public ResponseEntity<FetchMyPostResBody> fetcMyPost(@RequestBody FetchMyPostReqBody req){
		
		return service.fetchMyPost(req);
		
	}

}
