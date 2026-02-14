package com.twitter.CommonLibrary.FollowRelationshipDTO;


import lombok.Data;

@Data
public class FollowReqBody {
	
	private String followerEmail;
	
	private String followingEmail;

}
