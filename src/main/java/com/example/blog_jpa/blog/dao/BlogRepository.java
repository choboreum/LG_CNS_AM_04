package com.example.blog_jpa.blog.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.blog_jpa.blog.domain.entity.BlogEntity;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {
    @Query("""
        select b from BlogEntity b
        left join fetch b.comments
        where b.blogId = :blogId
    """)

    public Optional<BlogEntity> findWithComments(@Param("blogId") Integer blogId);
}
