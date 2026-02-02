package com.example.blog_jpa.user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.blog_jpa.common.service.RefreshTokenService;
import com.example.blog_jpa.common.util.JwtProvider;
import com.example.blog_jpa.user.dao.UserRepository;
import com.example.blog_jpa.user.domain.dto.UserRequestDTO;
import com.example.blog_jpa.user.domain.dto.UserResponseDTO;
import com.example.blog_jpa.user.domain.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    /**
     * 암호(평문이 아닌 암호화 및 복호화) : spring security
     * 토큰 : access, refresh
     */


    //Mapper 의존성 주입
    private final UserRepository userRepository;

    //token + redis 의존성 주입
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;

    @Transactional
    public UserResponseDTO join(UserRequestDTO userRequestDTO){
        System.out.println(">>>> userRepository join");

        return Optional.of(userRequestDTO)
                    .filter(req -> !userRepository.existsById(req.getEmail()))
                    .map(req -> userRepository.save(req.toEntity()))
                    .map(UserResponseDTO::fromEntity)
                    .orElseThrow(() -> new RuntimeException("사용자가 존재합니다."));
    }

    @Transactional
    public Map<String, Object> login(UserRequestDTO userRequestDTO){
        System.out.println(">>>> userRepository login");
        Map<String, Object> map = new HashMap<>();

        System.out.println(">>>> 1. userRepository login 사용자 조회");
        UserEntity userEntity = userRepository.findByEmailAndPassword(userRequestDTO.getEmail(), userRequestDTO.getPassword())
                                            .orElseThrow(
                                                () -> new RuntimeException(">>>> UserService login 실패!!!!")
                                            );
        
        System.out.println(">>>> 2. userRepository login 토큰 설정");
        String at = jwtProvider.createAT(userEntity.getEmail());
        String rt = jwtProvider.createRT(userEntity.getEmail());
        
        System.out.println(">>>> 3. userRepository RT 토큰 redis 저장");
        refreshTokenService.saveToken(userEntity.getEmail(), rt);

        map.put("response", UserResponseDTO.fromEntity(userEntity));
        //map.put("access", "jwt-access-token");
        map.put("access", at);
        //map.put("refresh", "jwt-refresh-token");
        map.put("refresh", rt);
        
        return map;
    }

    public void logout(String accessToken){
        System.out.println(">>>> userService logout()");

        String email = jwtProvider.getUserEmailFromToken(accessToken);
        refreshTokenService.deleteToken(email);
    }
}
