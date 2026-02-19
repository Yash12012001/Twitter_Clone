package com.twitter.DBInstance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.CommonLibrary.FetchMyFeedDTO.FetchMyFeedReqBody;
import com.twitter.CommonLibrary.FetchMyFeedDTO.FetchMyFeedResBody;
import com.twitter.DBInstance.Service.FetchContentDbSvc;

@RestController
@RequestMapping("/User-Fetch-My-Feed")
public class FetchMyFeedCntlr {

	@Autowired
	FetchContentDbSvc service;
	
	@PostMapping
	public ResponseEntity<FetchMyFeedResBody> fetchMyFeed(@RequestBody FetchMyFeedReqBody req){
		return service.fetchMyFeed(req);
		
	}
	
}
