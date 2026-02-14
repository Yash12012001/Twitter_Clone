package com.twitter.LoginSignUp.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;




public class UserInfo implements UserDetails {
	
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;
	
	
	
	public UserInfo(DataUser userData) {
		this.userName=userData.getEmail();
		this.password=userData.getPassword();
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority("User"));
		this.authorities=list;
		
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public @Nullable String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return userName;
	}

}
