package com.example.blog.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.blog.user.domain.dto.UserRequestDTO;
import com.example.blog.user.domain.dto.UserResponseDTO;

@Mapper
public interface UserMapper {

    public int insertRow(UserRequestDTO userRequestDTO);
    
    public UserResponseDTO selectRow(UserRequestDTO userRequestDTO);
}
