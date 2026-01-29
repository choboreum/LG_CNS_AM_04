package com.example.blog_jpa.comment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog_jpa.comment.domain.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{
    
}
