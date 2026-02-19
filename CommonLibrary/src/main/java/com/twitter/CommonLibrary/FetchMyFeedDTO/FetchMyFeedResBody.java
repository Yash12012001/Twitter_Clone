package com.twitter.CommonLibrary.FetchMyFeedDTO;

import java.util.List;

import lombok.Data;

@Data
public class FetchMyFeedResBody {
	
	private String status;
	
	private List<FeedObj> feedObj;

}
