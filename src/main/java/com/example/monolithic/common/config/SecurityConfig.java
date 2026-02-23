package com.example.monolithic.common.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.monolithic.common.auth.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder(){ //평문을 암호화해서 해싱처리
        return new BCryptPasswordEncoder();
    }

    // cors 설정(preflight)
    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000")); // res.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        corsConfiguration.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS")); // res.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Content-Type")); // res.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        corsConfiguration.setExposedHeaders(List.of("Authorization")); // headers.add("Access-Control-Expose-Headers", "Authorization, Refresh-Token");
        corsConfiguration.setAllowCredentials(true); // res.setHeader("Access-Control-Allow-Credentials", "true");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return source;
    }

    // 가장 중요한 메서드 설정 filter chain, cors configuration 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable()) //Cross-Site Request Forgery(사이트 위변조)
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/users/login").permitAll() // 해당 패턴(경로)는 누구나 접근이 가능하다
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // .requestMatchers("").authenticated() // 인증이 필요한 endpoint
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // 세션으로 관리되는 것들을 무력화 시키는 작업

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
