package com.example.am_spring.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.am_spring.user.dao.UserMapper;
import com.example.am_spring.user.domain.dto.UserRequestDTO;

@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;

    public void insert(UserRequestDTO userRequestDTO){
        System.out.println(">>>> UserService insert");
        userMapper.insertRow(userRequestDTO);
    }
}
