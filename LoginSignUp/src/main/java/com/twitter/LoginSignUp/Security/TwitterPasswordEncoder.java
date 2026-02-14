package com.twitter.LoginSignUp.Security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class TwitterPasswordEncoder implements PasswordEncoder{
	
	 
	
		//Method for Password Hashing. 
		@Value("${app.security.passKey}")
		private String passKey;
		
		@Override
		public @Nullable String encode(@Nullable CharSequence rawPassword) {
				 
				MessageDigest digest;
				byte[] hash = null;
				try {
					digest = MessageDigest.getInstance("SHA-256");
					String[] saltval= passKey.split("[|]");
					String pass=(String)rawPassword;
					String password = saltval[0] + pass.substring(0, 10) + saltval[1] + pass.substring(10, pass.length()) + saltval[2];
					hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
				} catch (NoSuchAlgorithmException e) {
		 
					e.printStackTrace();
				}
				StringBuilder hexString = new StringBuilder(2 * hash.length);
				for (int i = 0; i < hash.length; i++) {
					String hex = Integer.toHexString(0xff & hash[i]);
					if (hex.length() == 1) {
						hexString.append('0');
					}
					hexString.append(hex);
				}
				return hexString.toString();
			
		}
		@Override
		public boolean matches(@Nullable CharSequence rawPassword, @Nullable String encodedPassword) {
			String comparePassword = encode(rawPassword);
			
			return comparePassword.equals(encodedPassword);
		}



}
