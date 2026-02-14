package com.twitter.DBInstance.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.twitter.CommonLibrary.Constants.StatusCodes;
import com.twitter.CommonLibrary.FetchUserDataDTO.FetchUserDataReqBody;
import com.twitter.CommonLibrary.FollowRelationshipDTO.FollowReqBody;
import com.twitter.CommonLibrary.FollowRelationshipDTO.FollowResBody;
import com.twitter.DBInstance.Entity.DataUser;
import com.twitter.DBInstance.Entity.Follow;
import com.twitter.DBInstance.Repository.IDataUserRepo;
import com.twitter.DBInstance.Repository.IFollowRepo;

@Service
public class FollowRelationshipDBSvc {
	
	@Autowired
	private IFollowRepo followRepo;
	
	@Autowired
	private UserDBSvc userDBSvc;
	
	@Autowired
	IDataUserRepo repo;
	
	public ResponseEntity<Object> insert(FollowReqBody req){
		try {
			DataUser follower = repo.findById(req.getFollowerEmail()).get();
			DataUser following = repo.findById(req.getFollowingEmail()).get();
			
			Optional<Follow> checkFollow = followRepo.findByFollowerAndFollowing(follower.getEmail(),following.getEmail());
			
			if(checkFollow.isPresent()) {
				FollowResBody res= new FollowResBody();
				res.setStatus(StatusCodes.RedundantCall);
				return new ResponseEntity(res,HttpStatus.OK);
			}else {
				Follow follow = new Follow();
				follow.setFollower(follower);
				follow.setFollowing(following);
				Follow savedFollow = followRepo.save(follow);
				if(savedFollow!=null) {
					FollowResBody res= new FollowResBody();
					res.setStatus(StatusCodes.Sucess);
					return new ResponseEntity(res,HttpStatus.OK); 
				}else {
					FollowResBody res= new FollowResBody();
					res.setStatus(StatusCodes.Exception);
					return new ResponseEntity(res,HttpStatus.OK);
				}
			}
			
		}catch(Exception e){
			FollowResBody res= new FollowResBody();
			res.setStatus(StatusCodes.Exception);
			return new ResponseEntity(res,HttpStatus.OK);
		}
			
		}
	
	@Async
	private DataUser fetchUserData (String userId) {
		
		FetchUserDataReqBody userDataFollowerReq = new FetchUserDataReqBody();
		userDataFollowerReq.setEmail(userId);
		
		return repo.getById(userId);
		
	}
		
		
	
	
	
	
	

}
