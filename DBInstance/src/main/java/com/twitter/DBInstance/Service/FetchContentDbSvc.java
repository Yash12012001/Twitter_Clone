package com.twitter.DBInstance.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.twitter.CommonLibrary.Constants.StatusCodes;
import com.twitter.CommonLibrary.FetchMyFeedDTO.FeedObj;
import com.twitter.CommonLibrary.FetchMyFeedDTO.FetchMyFeedReqBody;
import com.twitter.CommonLibrary.FetchMyFeedDTO.FetchMyFeedResBody;
import com.twitter.CommonLibrary.FetchMyPostDTO.FetchMyPostReqBody;
import com.twitter.CommonLibrary.FetchMyPostDTO.FetchMyPostResBody;
import com.twitter.DBInstance.Entity.Post;
import com.twitter.DBInstance.Repository.IPostRepo;

@Service
public class FetchContentDbSvc {
	
	@Autowired 
	IPostRepo repo;
	
	public ResponseEntity<FetchMyPostResBody> fetchMyPost(FetchMyPostReqBody req) {
		try{
			List<String> content =  repo.findAllContentByAuthorId(req.getAuthorId());
			FetchMyPostResBody res = new FetchMyPostResBody();
			if(content != null) {
				res.setMyPosts(content);
				res.setStatus(StatusCodes.Sucess);
			}else {
				res.setStatus(StatusCodes.Failure);
			}
			return new ResponseEntity<FetchMyPostResBody>(res,HttpStatus.OK);
		}catch (Exception e){
			FetchMyPostResBody res = new FetchMyPostResBody();
			res.setStatus(StatusCodes.Exception);
			return new ResponseEntity<FetchMyPostResBody>(res,HttpStatus.OK);

		}
	}
	
	public ResponseEntity<FetchMyFeedResBody> fetchMyFeed(FetchMyFeedReqBody req){
		try {
			
			List<Post> followingPosts = repo.findFeedForUser(req.getUserId());
			FetchMyFeedResBody res = new FetchMyFeedResBody();
			if(followingPosts!=null) {
			List<FeedObj> feed = new ArrayList<>();
			for(Post p: followingPosts) {
				FeedObj feedObj = new FeedObj();
				feedObj.setAuthorId(p.getAuthor().getUsername());
				feedObj.setContent(p.getContent());
				feed.add(feedObj);
			}
			
			res.setStatus(StatusCodes.Sucess);
			res.setFeedObj(feed);
			return new ResponseEntity<FetchMyFeedResBody>(res,HttpStatus.OK);
			}else {
				res.setStatus(StatusCodes.Failure);
				return new ResponseEntity<FetchMyFeedResBody>(res,HttpStatus.OK);
			}
			
		}catch(Exception e) {
			FetchMyFeedResBody res = new FetchMyFeedResBody();
			res.setStatus(StatusCodes.Exception);
			return new ResponseEntity<FetchMyFeedResBody>(res,HttpStatus.OK);
			
		}
	}

}
