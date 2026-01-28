package com.example.blog.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.blog.common.service.RefreshTokenService;
import com.example.blog.common.token.JwtProvider;
import com.example.blog.user.dao.UserMapper;
import com.example.blog.user.domain.dto.UserRequestDTO;
import com.example.blog.user.domain.dto.UserResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    /**
     * 암호(평문이 아닌 암호화 및 복호화) : spring security
     * 토큰 : access, refresh
     */


    //Mapper 의존성 주입
    private final UserMapper userMapper;

    //token + redis 의존성 주입
    private final JwtProvider jwtProvider;
    private final RefreshTokenService RefreshTokenService;

    public int join(UserRequestDTO userqRequestDTO){
        System.out.println(">>>> UserMapper join");
        return userMapper.insertRow(userqRequestDTO);
    }

    public Map<String, Object> login(UserRequestDTO userRequestDTO){
        System.out.println(">>>> UserMapper login");
        Map<String, Object> map = new HashMap<>();

        System.out.println(">>>> 1. UserMapper login 사용자 조회");
        UserResponseDTO userResponseDTO = userMapper.selectRow(userRequestDTO);
        if(userResponseDTO == null) {
            throw new RuntimeException(">>>> login 실패");
        }
        
        System.out.println(">>>> 2. UserMapper login 토큰 설정");
        String at = jwtProvider.createAT(userResponseDTO.getEmail());
        String rt = jwtProvider.createRT(userResponseDTO.getEmail());
        
        System.out.println(">>>> 3. UserMapper RT 토큰 redis 저장");
        RefreshTokenService.saveToken(userResponseDTO.getEmail(), rt);

        map.put("response", userMapper.selectRow(userRequestDTO));
        //map.put("access", "jwt-access-token");
        map.put("access", at);
        //map.put("refresh", "jwt-refresh-token");
        map.put("refresh", rt);
        return map;
    }

}
