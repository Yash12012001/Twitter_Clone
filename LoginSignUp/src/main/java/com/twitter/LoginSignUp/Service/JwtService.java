package com.twitter.LoginSignUp.Service;

import java.security.Key;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
	
	@Value("${app.Jwt.secretKey}")
	private String secretKey;
	
	public String generateToken(String email) {
		Map<String,Object> claims = new HashMap<>();
		return createToken(claims, email);
	}
	
	
	private String createToken (Map<String, Object> claims,String email) {
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(email)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60))
				.signWith(getSignKey(), SignatureAlgorithm.HS256)
				.compact();
		
	}
	
	private Key getSignKey() {
		byte [] keyBytes = secretKey.getBytes();
		return Keys.hmacShaKeyFor(keyBytes);
	}
	

    public String extractUsername(String token) {
        return extractClaim(token, claims-> claims.getSubject());
    }

    public Date extractExpiration(String token) {
        return (Date)extractClaim(token, claims-> claims.getExpiration());
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
        		.setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date(System.currentTimeMillis()+ 1000*60*60));
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    } 

}
