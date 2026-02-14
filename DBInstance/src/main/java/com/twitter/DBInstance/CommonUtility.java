//package com.twitter.DBInstance;
//
//
//import java.nio.charset.StandardCharsets;
//
//import java.security.MessageDigest;
//
//import java.security.NoSuchAlgorithmException;
// 
//import org.springframework.beans.factory.annotation.Value;
//
//import org.springframework.stereotype.Component;
// 
// 
//@Component
//
//public class CommonUtility {
// 
//	
//
//	//Method for Password Hashing.
//
//	@Value("${app.security.passKey}")
//
//	private String passKey;
//
//	public String bytesToHexPass(String pass) {
// 
//		MessageDigest digest;
//
//		byte[] hash = null;
//
//		try {
//
//			digest = MessageDigest.getInstance("SHA-256");
//
//			String[] saltval= passKey.split("[|]");
//
//			String password = saltval[0] + pass.substring(0, 10) + saltval[1] + pass.substring(10, pass.length()) + saltval[2];
//
//			hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
//
//			// System.out.println();
//
//		} catch (NoSuchAlgorithmException e) {
//
//			// TODO Auto-generated catch block
// 
//			e.printStackTrace();
//
//		}
//
//		StringBuilder hexString = new StringBuilder(2 * hash.length);
//
//		for (int i = 0; i < hash.length; i++) {
//
//			String hex = Integer.toHexString(0xff & hash[i]);
//
//			if (hex.length() == 1) {
//
//				hexString.append('0');
//
//			}
//
//			hexString.append(hex);
//
//		}
//
//		return hexString.toString();
//
//	}
//
//
//}
// 