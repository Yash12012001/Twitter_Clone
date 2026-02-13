package com.twitter.CommonLibrary.UpdateUserDataDTO;


import lombok.Data;

@Data
public class UpdateUserDataReqBody {
	
	private String email;
	private String name;
	private String userName;
	private String password;
}
