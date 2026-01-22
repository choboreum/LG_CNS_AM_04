package com.example.blog.blog.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.blog.blog.domain.dto.BlogRequestDTO;
import com.example.blog.blog.domain.dto.BlogResponseDTO;

@Mapper //url을 파싱하고 데이터를 전달 받음
public interface BlogMapper {
    
    public int insertRow(BlogRequestDTO blogRequestDTO);
    
    public BlogResponseDTO readRow(Integer blogId);
}
