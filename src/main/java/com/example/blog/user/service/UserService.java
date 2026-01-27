package com.example.blog.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.blog.user.dao.UserMapper;
import com.example.blog.user.domain.dto.UserRequestDTO;

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


    public int join(UserRequestDTO userqRequestDTO){
        System.out.println(">>>> UserMapper join");
        return userMapper.insertRow(userqRequestDTO);
    }

    public Map<String, Object> login(UserRequestDTO userRequestDTO){
        System.out.println(">>>> UserMapper login");
        Map<String, Object> map = new HashMap<>();
        map.put("response", userMapper.selectRow(userRequestDTO));
        map.put("access", "jwt-access-token");
        map.put("refresh", "jwt-refresh-token");
        return map;
    }

}
