package com.example.blog.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.blog.comment.domain.dto.CommentRequestDTO;
import com.example.blog.comment.domain.dto.CommentResponseDTO;

@Mapper
public interface CommentMapper {
    public int insertRow(CommentRequestDTO commentRequestDTO);
    public List<CommentResponseDTO> listRow(Integer blogId);
    public Integer deleteRow(Integer commentId);
}
