package com.example.blog.blog.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.blog.blog.domain.dto.BlogRequestDTO;
import com.example.blog.blog.domain.dto.BlogResponseDTO;

@Mapper //url을 파싱하고 데이터를 전달 받음
public interface BlogMapper {
    
    public int insertRow(BlogRequestDTO blogRequestDTO);
    
    public BlogResponseDTO readRow(Integer blogId);
    
    public int deleteRow(Integer blogId);

    public List<BlogResponseDTO> listRow();

    public int updateRow(Map<String, Object> blogRequestDTO); // ORM으로 데이터를 전달 할 수 있는 객체는 하나
}
