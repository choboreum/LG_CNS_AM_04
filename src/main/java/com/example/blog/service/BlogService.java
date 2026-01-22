package com.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.blog.dao.BlogMapper;
import com.example.blog.blog.domain.dto.BlogRequestDTO;
import com.example.blog.blog.domain.dto.BlogResponseDTO;

import lombok.RequiredArgsConstructor;

@Service(value = "blogService")
@RequiredArgsConstructor
public class BlogService {
    
    /*
    @Autowired // 객체 의존성 주입
    private BlogMapper blogMapper;
    */
    private final BlogMapper blogMapper;

    public int write(BlogRequestDTO blogRequestDTO){
        System.out.println(">>>> BlogService write()");

        return blogMapper.insertRow(blogRequestDTO);
    }

    public BlogResponseDTO read(Integer blogId){
        System.out.println(">>>> BlogService read()");

        return blogMapper.readRow(blogId);
    }

    public int delete(Integer blogId){
        System.out.println(">>>> BlogService delete()");

        return blogMapper.deleteRow(blogId);
    }
}
