package com.twitter.LoginSignUp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.twitter.CommonLibrary.FetchUserDataDTO.FetchUserDataReqBody;
import com.twitter.CommonLibrary.FetchUserDataDTO.FetchUserDataResBody;

import com.twitter.LoginSignUp.FeignClient.FeignClient;
import com.twitter.LoginSignUp.Model.DataUser;
import com.twitter.LoginSignUp.Model.UserInfo;
import com.twitter.LoginSignUp.Security.TwitterPasswordEncoder;

@Service
public class UserInfoSvc implements UserDetailsService {
	
	@Autowired
	FeignClient client;
	
	@Autowired
	TwitterPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		FetchUserDataReqBody reqForFeign = new FetchUserDataReqBody();

		
		ResponseEntity<FetchUserDataResBody> responseEntity = client.fetchUserData(reqForFeign);
		
		FetchUserDataResBody res =  responseEntity.getBody();
		
		if(res.getStatus().equals("DATA_FETCHED")) {
				DataUser user = new DataUser();
				user.setEmail(username);
				user.setPassword(username);
				
				return new UserInfo(user);
				
			} else {
				throw new UsernameNotFoundException("user not found");
			}
		
	}

}
