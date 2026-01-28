package com.example.blog.comment.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog.blog.dao.BlogMapper;
import com.example.blog.blog.domain.dto.BlogResponseDTO;
import com.example.blog.comment.dao.CommentMapper;
import com.example.blog.comment.domain.dto.CommentRequestDTO;
import com.example.blog.comment.domain.dto.CommentResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // final생성자를 위한 어노테이션
public class CommentService {
    
    // 의존성 주입을 필요로 함(CommentMapper or CommentRepository)
    private final BlogMapper blogMapper;
    private final CommentMapper commentMapper;

    /**
     * 데이터베이스 작업의 논리적인 단위로 트랜잭션처리가 필요
     * 트랜잭션 처리 :  commit, rollback
     */
    @Transactional
    public List<CommentResponseDTO> write(CommentRequestDTO commentRequestDTO) {
        System.out.println(">>>> CommentService write");
        List<CommentResponseDTO> list = null;

        BlogResponseDTO blogResponseDTO = blogMapper.readRow(commentRequestDTO.getBlogId());

        if(blogResponseDTO != null){
            int flag = commentMapper.insertRow(commentRequestDTO);
            System.out.println(">>>> CommentService write flag : " + flag);
            System.out.println(">>>> CommentService write comment id : " + commentRequestDTO.getCommentId());
            if(flag == 1){
                list = commentMapper.listRow(commentRequestDTO.getBlogId());
                
                return list;
            }
        } else {
            throw new RuntimeException("blog not found!!");
        }

        return list;
    }
    
    @Transactional
    public int delete(Integer commentId){
        System.out.println(">>>> CommentService delete");

        return commentMapper.deleteRow(commentId);
    }
}
