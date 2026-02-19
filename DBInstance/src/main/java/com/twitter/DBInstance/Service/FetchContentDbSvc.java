package com.twitter.DBInstance.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.twitter.DBInstance.Repository.IPostRepo;

@Service
public class FetchContentDbSvc {
	
	@Autowired 
	IPostRepo repo;
	
	public ResponseEntity<FetchMyPostResBody> fetchMyPost(FetchMyPostReqBody req) {
		try{
			List<>
		}catch (Exception e){

		}
	}
	
	public ResponseEntity<Object> fetchMyFeed(){
		return null;
	}

}
