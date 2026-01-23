package com.example.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog.blog.dao.BlogMapper;
import com.example.blog.blog.domain.dto.BlogRequestDTO;
import com.example.blog.blog.domain.dto.BlogResponseDTO;

import lombok.RequiredArgsConstructor;

@Service(value = "blogService")
@RequiredArgsConstructor
@Transactional
public class BlogService {
    
    /*
    @Autowired // 객체 의존성 주입
    private BlogMapper blogMapper;
    */
    private final BlogMapper blogMapper;

    @Transactional 
    public int write(BlogRequestDTO blogRequestDTO){
        System.out.println(">>>> BlogService write()");

        return blogMapper.insertRow(blogRequestDTO);
    }

    @Transactional(readOnly = true) // 읽기전용의 트랜잭션
    public BlogResponseDTO read(Integer blogId){
        System.out.println(">>>> BlogService read()");

        return blogMapper.readRow(blogId);
    }

    @Transactional 
    public int delete(Integer blogId){
        System.out.println(">>>> BlogService delete()");

        return blogMapper.deleteRow(blogId);
    }

    @Transactional(readOnly = true) // 읽기전용의 트랜잭션
    public List<BlogResponseDTO> list(){
        System.out.println(">>>> BlogService list()");

        return blogMapper.listRow();
    }
}
