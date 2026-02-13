package com.twitter.Follow.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.twitter.CommonLibrary.FollowRelationshipDTO.FollowReqBody;




@org.springframework.cloud.openfeign.FeignClient(name = "FollowDb", url = "http://localhost:8080", path = "/User-Follow-Operations", configuration = FeignClientConfig.class)
public interface FeignClientFollow {
	
	
	@PostMapping("/Follow")
	public ResponseEntity<Object> followUser(@RequestBody FollowReqBody req);
	

}
