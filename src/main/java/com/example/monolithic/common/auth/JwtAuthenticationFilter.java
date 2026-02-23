package com.example.monolithic.common.auth;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    @Value("${jwt.secret}")
    private String secret;
    private Key key;

    @PostConstruct
    private void init(){
        System.out.println(">>>> JwtAuthenticationFilter init secret : " + secret);
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        System.out.println(">>>> JwtAuthenticationFilter doFilterInternal");

        String endPoint = request.getRequestURI();
        System.out.println(">>>> JwtAuthenticationFilter User endPoint" + endPoint);
        String method = request.getMethod();
        System.out.println(">>>> JwtAuthenticationFilter Request method" + method);

        
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            // config 처리 예정
            // response.setStatus(HttpServletResponse.SC_OK);
            // response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
            // response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
            // response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
            // response.setHeader("Access-Control-Allow-Credentials", "true");

            chain.doFilter(request, response);
            return ;
        }

        // header, token 검증을 해서 통과 또는 리젝
        String authHeader = request.getHeader("Authorization");
        
        System.out.println(">>>> JwtAuthenticationFilter authHeader : " + authHeader);
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            System.out.println(">>>> JwtAuthenticationFilter Not authHeader : ");
            chain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        System.out.println(">>>> JwtAuthenticationFilter token : " + token);
        System.out.println(">>>> JwtAuthenticationFilter token validation check");

        try{
            //Claims == JWT 데이터
            Claims claims = Jwts.parserBuilder()
                                .setSigningKey(key)
                                .build()
                                .parseClaimsJws(token)
                                .getBody();
            String email = claims.getSubject(); //기본키인 email에 subject를 담음(subject는 provider에서 사용자의 기본키 계정을 담고 있다)
            System.out.println(">>>> JwtAuthenticationFilter claims get email : " + email);
            
            // JWTProvider에 role이 입력된 경우에만 해당
            String role = claims.get("role", String.class);
            System.out.println(">>>> JwtAuthenticationFilter claims get role : " + role);

            // spring security에 인증정보를 담는 객체(Principal, credential, authorities) : UsernamePasswordAuthenticationToken
            // 객체를 담아서 관리해주는 폴더 같은 개념 : SecurityContentHolder

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, null, role != null ? java.util.List.of(() -> "ROLE_" + role) : java.util.List.of() );
            // 사용자 요청과 인증정보 객체를 연결
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // SecurityContext 저장 -> Ctrl 필요할때 꺼낼수 ㅣㅆ음
            // 사용자의 상태정보를 확인
            SecurityContextHolder.getContext().setAuthentication(authentication);


        } catch(Exception e){
            e.printStackTrace();
        }

        chain.doFilter(request, response);
    }
}