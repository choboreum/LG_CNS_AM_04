package com.example.blog_jpa.comment.domain.entity;

import com.example.blog_jpa.blog.domain.entity.BlogEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 테이블을 의미
@Table(name = "JPA_COMMENT_TBL") // 테이블의 네이밍 가능, 없이 사용하면 class명이 테이블명이 됨
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {
    @Id // 기본키를 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키의 값을 넣지않고 채번할 경우의 전략
    private Integer commentId;

    @Column(nullable = true, length = 500)
    private String content;

    // 외래키 설정 :entity 끼리의 관계
    @ManyToOne(fetch = FetchType.LAZY, optional = false) //optional : null을 허용하지 않겠다라는 의미
    @JoinColumn(name = "blogId")
    private BlogEntity blog;
}