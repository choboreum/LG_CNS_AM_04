package com.example.blog_jpa.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog_jpa.blog.domain.entity.BlogEntity;

public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {
    
}
