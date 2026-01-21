package com.example.am_spring.user.dao;

import org.apache.ibatis.annotations.Mapper;
import com.example.am_spring.user.domain.dto.UserRequestDTO;

@Mapper
public interface UserMapper {
    // INSERT INTO user_tbl(email, password, name) VALUES (?, ?, ?);
    public void insertRow(UserRequestDTO userRequestDTO);
} 
