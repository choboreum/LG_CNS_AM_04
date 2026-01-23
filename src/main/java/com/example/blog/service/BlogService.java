package com.example.blog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Transactional
    public int update(Integer blogId, BlogRequestDTO blogRequestDTO){
        System.out.println(">>>> BlogService update()");
        Map<String, Object> map = new HashMap<>();
        map.put("blogId", blogId);
        map.put("title", blogRequestDTO.getTitle());
        map.put("content", blogRequestDTO.getContent());

        return blogMapper.updateRow(map); //blogId를 blogRequestDTO에 담아 매개변수 하나만 보내준다.
                                                    //그럼 blogRequestDTO에는 SETTER 필요
    }
}
