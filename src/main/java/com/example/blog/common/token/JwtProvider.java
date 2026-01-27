package com.example.blog.common.token;

import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

	public String createAT(String email) {
		return "access-token-for-" + email;
	}
	
	public String createRT(String email) {
		return "refresh-token-for-" + email;

	}
}