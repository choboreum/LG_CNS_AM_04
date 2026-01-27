package com.example.blog.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") //사용자로 들어올 수 있는 매핑
                .allowedHeaders("*") //헤더
                .allowedOriginPatterns("http://localhost:3000") //프론트 endpoint
                .allowedMethods("*") //요청 되어지는 메소드 방식
                .allowCredentials(true); //인증 허용 여부
    }
}
