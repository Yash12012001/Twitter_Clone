package com.twitter.LoginSignUp.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.twitter.CommonLibrary.FetchUserDataDTO.FetchUserDataReqBody;
import com.twitter.CommonLibrary.FetchUserDataDTO.FetchUserDataResBody;
import com.twitter.CommonLibrary.InsertUserDTO.InsertUserDataReqBody;




@org.springframework.cloud.openfeign.FeignClient (name = "UserDb", url = "http://localhost:8080", path = "/User-DB-Operations", configuration = FeignClientConfig.class)
public interface FeignClient {
	
	@PostMapping("/Insert")
	public ResponseEntity<Object> insertUserData(@RequestBody InsertUserDataReqBody req);
	
	@PostMapping("/Fetch")
	public ResponseEntity<FetchUserDataResBody> fetchUserData(@RequestBody FetchUserDataReqBody req);

}
