package com.example.blog_jpa.comment.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog_jpa.blog.dao.BlogRepository;
import com.example.blog_jpa.blog.domain.dto.BlogResponseDTO;
import com.example.blog_jpa.blog.domain.entity.BlogEntity;
import com.example.blog_jpa.comment.dao.CommentRepository;
import com.example.blog_jpa.comment.domain.dto.CommentRequestDTO;
import com.example.blog_jpa.comment.domain.dto.CommentResponseDTO;
import com.example.blog_jpa.comment.domain.entity.CommentEntity;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // final생성자를 위한 어노테이션
public class CommentService {
    
    // 의존성 주입을 필요로 함(CommentMapper or CommentRepository)
    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;

    /**
     * 데이터베이스 작업의 논리적인 단위로 트랜잭션처리가 필요
     * 트랜잭션 처리 :  commit, rollback
     */
    @Transactional
    public List<CommentResponseDTO> write(CommentRequestDTO commentRequestDTO) {
        System.out.println(">>>> CommentService write");
        List<CommentResponseDTO> list = null;

        BlogEntity blogEntity = blogRepository.findById(commentRequestDTO.getBlogId())
                                            .orElseThrow(() -> new EntityNotFoundException("Blog not found : " + commentRequestDTO.getBlogId()));

        commentRepository.save(commentRequestDTO.toEntity(blogEntity));

                                // comment.blog.blogId
                                // comment.blog_blogId
                                // findByBlogBlogId -> blogBlogId (X)
        return commentRepository.findByBlog_BlogId(commentRequestDTO.getBlogId())
                                .stream()
                                .map(CommentResponseDTO::fromEntity)
                                .toList();
    }
    
    @Transactional
    public void delete(Integer commentId){
        System.out.println(">>>> CommentService delete");

        CommentEntity commentEntity = commentRepository.findById(commentId)
                                .orElseThrow(() -> new EntityNotFoundException("댓글 없음 : " + commentId));
        commentRepository.delete(commentEntity);
    }

    // 리팩토링 측면에서 공통의 코드를 메서드로 정의
    private String getAuthEmail(){
        return SecurityContextHolder.getContext()
                                    .getAuthentication()
                                    .getName();
    }
}
