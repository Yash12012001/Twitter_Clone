//package com.twitter.LoginSignUp.Security;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.twitter.LoginSignUp.Model.UserInfo;
//import com.twitter.LoginSignUp.Service.JwtService;
//import com.twitter.LoginSignUp.Service.UserInfoSvc;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class JwtAuthFilter extends OncePerRequestFilter {
//
//	@Autowired
//	JwtService jwtService;
//
//	@Autowired
//	private UserInfoSvc userInfoSvc;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//
//		System.out.println("reached");
//
//		String path = request.getServletPath();
//		if(path.equalsIgnoreCase("/TwiterClone/Login") || path.equalsIgnoreCase("/TwitterClone/SignUp")) {
//			filterChain.doFilter(request, response);
//			return;
//		}
//
//
//
//
//		String authToken= request.getHeader("Authorization");
//		String token=null;
//		String userName=null;
//
//		if(authToken!=null && authToken.startsWith("Bearer ")) {
//			token = authToken.substring(7);
//			userName = jwtService.extractUsername(token);
//		}
//
//		if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
//			UserDetails userDetails = userInfoSvc.loadUserByUsername(userName);
//
//			if(jwtService.validateToken(token, userDetails)) {
//
//				UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken =
//						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//
//				userNamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);
//
//			}
//		}
//		filterChain.doFilter(request, response);
//	}
//
//}
