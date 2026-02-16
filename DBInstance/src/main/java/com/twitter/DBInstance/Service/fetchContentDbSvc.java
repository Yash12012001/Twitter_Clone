package com.twitter.DBInstance.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.twitter.DBInstance.Repository.IPostRepo;

@Service
public class fetchContentDbSvc {
	
	@Autowired 
	IPostRepo repo;
	
	public ResponseEntity<Object> fetchMyPost() {
		return null;	
	}
	
	public ResponseEntity<Object> fetchMyFeed(){
		return null;
	}

}
