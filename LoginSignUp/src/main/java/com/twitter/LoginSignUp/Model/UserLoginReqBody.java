package com.twitter.LoginSignUp.Model;

import lombok.Data;

@Data
public class UserLoginReqBody {
	
	private String email;
	private String userName;
	private String password;

}
