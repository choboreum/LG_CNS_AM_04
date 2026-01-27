package com.example.blog.user.service;

import org.springframework.stereotype.Service;

import com.example.blog.user.dao.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    //Mapper 의존성 주입
    private final UserMapper userMapper;

}
