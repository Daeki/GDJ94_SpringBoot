package com.winter.app.config.security.jwt;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	
	private JwtTokenManager tokenManager;
	
	public JwtLoginFilter(JwtTokenManager tokenManager, AuthenticationManager authenticationManager) {
		this.setFilterProcessesUrl("/users/loginProcess");
		this.tokenManager=tokenManager;
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		System.out.println("login 시도");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		//UserDetailService의 loadUserByusername 메서드를 호출하고
		//패스워드가 일치하는지 판별하고 Authentication객체를 
		//SecurityContextHolder에 넣어줌
		
		return authenticationManager.authenticate(authenticationToken);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String accesstoken = tokenManager.makeAccessToken(authResult);
		String refreshToken = tokenManager.makeRefreshToken(authResult);
		
		Cookie cookie = new Cookie("access-token", accesstoken);
		cookie.setPath("/");
		cookie.setMaxAge(60);
		cookie.setHttpOnly(true);
		
		response.addCookie(cookie);
		
		cookie = new Cookie("refresh-token", refreshToken);
		cookie.setPath("/");
		cookie.setMaxAge(60);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		
		response.sendRedirect("/");
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.unsuccessfulAuthentication(request, response, failed);
	}
}
