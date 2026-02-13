package com.twitter.Follow.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.twitter.CommonLibrary.FetchUserDataDTO.FetchUserDataReqBody;
import com.twitter.CommonLibrary.FetchUserDataDTO.FetchUserDataResBody;




@org.springframework.cloud.openfeign.FeignClient(name = "UserDb", url = "http://localhost:8080", path = "/User-DB-Operations", configuration = FeignClientConfig.class)
public interface FeignClientUserDb {
	
	@PostMapping("/Fetch")
	public ResponseEntity<FetchUserDataResBody> fetchUserData(@RequestBody FetchUserDataReqBody req);

}
