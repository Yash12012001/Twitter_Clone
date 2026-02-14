package com.twitter.Follow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.twitter.CommonLibrary.FetchUserDataDTO.FetchUserDataReqBody;
import com.twitter.CommonLibrary.FollowRelationshipDTO.FollowReqBody;
import com.twitter.Follow.FeignClient.FeignClientFollow;
import com.twitter.Follow.FeignClient.FeignClientUserDb;
import com.twitter.Follow.Model.FollowUnFollowReqBody;

@Service
public class FollowSvc {
	
	@Autowired 
	FeignClientFollow clientFollow;
	
	@Autowired
	FeignClientUserDb clientUserDb;
	
	public ResponseEntity<Object> followUser(FollowUnFollowReqBody req){
		return null;
	}
	

	private FollowReqBody createFollowReq(FollowUnFollowReqBody req) {
		
		FetchUserDataReqBody userDataFollowerReq = new FetchUserDataReqBody();
		userDataFollowerReq.setEmail(req.getFolloweId());
		
		
		
		FollowReqBody followReq = new FollowReqBody();
		followReq.setFollowerEmail(req.getFollowerId());
		followReq.setFollowingEmail(req.getFolloweId());
		
		return followReq;
		
	}
	
	

	
}
