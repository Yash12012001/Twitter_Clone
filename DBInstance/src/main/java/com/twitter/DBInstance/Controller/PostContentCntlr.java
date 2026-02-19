package com.twitter.DBInstance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.CommonLibrary.PostContentDTO.PostContentReqBody;
import com.twitter.CommonLibrary.PostContentDTO.PostContentResBody;
import com.twitter.DBInstance.Service.PostContentDBSvc;

@RestController
@RequestMapping("/User-Post-Content")
public class PostContentCntlr {
	
	@Autowired
	PostContentDBSvc service;
	
	@PostMapping
	public ResponseEntity<PostContentResBody> postContent(@RequestBody PostContentReqBody req){
		return service.postContent(req);
	}

}
