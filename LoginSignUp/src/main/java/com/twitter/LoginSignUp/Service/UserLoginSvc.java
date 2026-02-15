package com.twitter.LoginSignUp.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.twitter.CommonLibrary.Constants.StatusCodes;
import com.twitter.CommonLibrary.FetchUserDataDTO.FetchUserDataReqBody;
import com.twitter.CommonLibrary.FetchUserDataDTO.FetchUserDataResBody;
import com.twitter.LoginSignUp.FeignClient.FeignClient;
import com.twitter.LoginSignUp.Model.UserLoginReqBody;
import com.twitter.LoginSignUp.Security.TwitterPasswordEncoder;

@Service
public class UserLoginSvc {
	
	@Autowired
	FeignClient client;
	
//	@Autowired
//	JwtService jwtService;
	
	@Autowired 
	private TwitterPasswordEncoder encoder;
	
	
	
	public ResponseEntity userLogin(UserLoginReqBody req) {
		
		FetchUserDataReqBody reqForFeign = new FetchUserDataReqBody();
		
		if(req.getEmail().isEmpty()) {
			reqForFeign.setUserName(req.getUserName());
		}else {
			reqForFeign.setEmail(req.getEmail());
		}
		
		ResponseEntity<FetchUserDataResBody> responseEntity = client.fetchUserData(reqForFeign);
		
		FetchUserDataResBody res =  responseEntity.getBody();
		
		if(res.getStatus().equalsIgnoreCase(StatusCodes.Sucess)) {
			if(encoder.matches(req.getPassword(), res.getPassword())) {
				
				Map<String,Object> responseMap = new HashMap<>();
//				String bearerToken = jwtService.generateToken(res.getEmail());
				
//				responseMap.put("Bearer", bearerToken);
				responseMap.put("msg", "login succesful");
				return new ResponseEntity(responseMap,HttpStatus.OK);
			} else {
				return new ResponseEntity("Wrong Password",HttpStatus.OK);
			}
		}else {
			return new ResponseEntity("User Does Not Exists",HttpStatus.OK);
		}
		
		
		
	}

}
