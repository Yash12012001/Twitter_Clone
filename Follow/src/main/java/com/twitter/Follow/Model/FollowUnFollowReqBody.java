package com.twitter.Follow.Model;

import lombok.Data;

@Data
public class FollowUnFollowReqBody {

	private String followerId;
	private String followeId;
	
}
