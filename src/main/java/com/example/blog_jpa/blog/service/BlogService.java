package com.example.blog_jpa.blog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog_jpa.blog.dao.BlogRepository;
import com.example.blog_jpa.blog.domain.dto.BlogRequestDTO;
import com.example.blog_jpa.blog.domain.dto.BlogResponseDTO;
import com.example.blog_jpa.blog.domain.entity.BlogEntity;
import com.example.blog_jpa.comment.dao.CommentRepository;
import com.example.blog_jpa.comment.domain.dto.CommentResponseDTO;
import com.example.blog_jpa.user.dao.UserRepository;

import lombok.RequiredArgsConstructor;

@Service(value = "blogService")
@RequiredArgsConstructor
@Transactional
public class BlogService {
    private final UserRepository userRepository;
    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;

    @Transactional 
    public BlogResponseDTO write(BlogRequestDTO blogRequestDTO){
        System.out.println(">>>> BlogService write()");
        
        Authentication auth = SecurityContextHolder.getContext()
                                                    .getAuthentication();
    
        String email = auth.getName();
        System.out.println(">>>> BlogService auth email : " + email);
        
        return userRepository.findById(email)
                            .map(user -> {
                                BlogEntity blogEntity = blogRepository.save(
                                /*
                                BlogEntity.builder()
                                        .title(userRequestDTO.getTitle())
                                        .content(userRequestDTO.getContent())
                                        .author(user)
                                        .build();
                                */
                                blogRequestDTO.toEntity(user)
                                );

                                return BlogResponseDTO.fromEntityWithoutComments(blogEntity);
                            })
                            .orElseThrow(() -> new RuntimeException("사용자 인증 오류"));
    }

    @Transactional(readOnly = true) // 읽기전용의 트랜잭션
    public BlogResponseDTO read(Integer blogId){
        System.out.println(">>>> BlogService read()");
        /**
         * bad case) ?
         * 댓글 100개면 : 
         * 블로그 1번, 댓글 100번 쿼리
         * BlogEntity blogEntity = blogRespository.findById(id).get();
         * List<CommentEntity> comments = blog.getComments();
         * 
         * best case)
         * Blog + Comments 한번에 조회
         */
        
        return blogRepository.findWithComments(blogId)
                            .map(BlogResponseDTO::fromEntityWithComments)
                            .orElseThrow(() -> new RuntimeException("게시글 없음"));
    }

    @Transactional 
    public void delete(Integer blogId){
        System.out.println(">>>> BlogService delete()");

        BlogEntity blogEntity = blogRepository.findById(blogId)
                                        .orElseThrow(() -> new RuntimeException("게시글 없음"));

        blogRepository.delete(blogEntity);
    }

    @Transactional(readOnly = true) // 읽기전용의 트랜잭션
    public List<BlogResponseDTO> list(){
        System.out.println(">>>> BlogService list()");

        return blogRepository.findAll()
                .stream()
                .map(BlogResponseDTO::fromEntityWithoutComments) 
                .toList();
    }

    @Transactional
    public BlogResponseDTO update(Integer blogId, BlogRequestDTO blogRequestDTO){
        System.out.println(">>>> BlogService update()");
        BlogEntity blogEntity = blogRepository.findById(blogId)
            .orElseThrow(() -> new RuntimeException("게시글 없음"));

        blogEntity.update(blogRequestDTO.getTitle(), blogRequestDTO.getContent());
        // save() 안 해도 됨 (Dirty Checking)
        // blogRepository.save(blog) ;
        
        return BlogResponseDTO.fromEntityWithoutComments(blogEntity);
    }
}

