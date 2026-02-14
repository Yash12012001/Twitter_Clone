package com.twitter.DBInstance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.CommonLibrary.DeleteUserDTO.DeleteUserDataReqBody;
import com.twitter.CommonLibrary.FetchUserDataDTO.FetchUserDataReqBody;
import com.twitter.CommonLibrary.InsertUserDTO.InsertUserDataReqBody;
import com.twitter.CommonLibrary.UpdateUserDataDTO.UpdateUserDataReqBody;
import com.twitter.DBInstance.Service.UserDBSvc;

@RestController
@RequestMapping("/User-DB-Operations")
public class UserDBCntlr {
	
	@Autowired 
	UserDBSvc service;
	
	@PostMapping("/Insert")
	public ResponseEntity<Object> insertUserData(@RequestBody InsertUserDataReqBody req) {
		return service.insertUserData(req);
	}
	
	@PostMapping("/Update")
	public ResponseEntity<Object> updateUserData(@RequestBody UpdateUserDataReqBody req) {
		return service.updateUserData(req);
	}
	
	@PostMapping("/Fetch")
	public ResponseEntity<Object> fetchUserData(@RequestBody FetchUserDataReqBody req) {
		return service.fetchUserData(req);
	}
	
	@DeleteMapping("/Delete")
	public ResponseEntity<Object> deleteUserData(@RequestBody DeleteUserDataReqBody req) {
		return service.deleteUserData(req);
	}

}
