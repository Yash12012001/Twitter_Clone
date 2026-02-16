package com.twitter.DBInstance.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.twitter.CommonLibrary.Constants.StatusCodes;
import com.twitter.CommonLibrary.PostContentDTO.*;
import com.twitter.DBInstance.Entity.DataUser;
import com.twitter.DBInstance.Entity.Post;
import com.twitter.DBInstance.Repository.IDataUserRepo;
import com.twitter.DBInstance.Repository.IPostRepo;

@Service
public class PostContentDBSvc{

    @Autowired
    private IPostRepo repo;
    
    @Autowired
	IDataUserRepo userRepo;
    
    @Autowired
    

    public ResponseEntity<PostContentResBody> postContent (PostContentReqBody req){
        try {
        	
        	Post post = new Post();
        	DataUser user = getUserData(req.getAuthorId());
        	post.setContent(req.getContent());
        	post.setAuthor(user);
        	post.setCreatedAt(LocalDateTime.now());
        	
        	Post checkPost = repo.saveAndFlush(post);
        	PostContentResBody res =new PostContentResBody();
        	if(checkPost!=null) {
        	
        		res.setStatus(StatusCodes.Sucess);
        		return new ResponseEntity(res,HttpStatus.OK);
        	}else {
        		res.setStatus(StatusCodes.Failure);
        		return new ResponseEntity(res,HttpStatus.OK);
        	}
        	
        	
        }catch (Exception e) {
        	PostContentResBody res =new PostContentResBody();
        	res.setStatus(StatusCodes.Exception);
    		return new ResponseEntity(res,HttpStatus.OK);
        	
        }
    }
    
    @Async
    private DataUser getUserData(String userId) {
    	
    	DataUser user = userRepo.findById(userId).get();
    	
    	return user;
    	
    }

}