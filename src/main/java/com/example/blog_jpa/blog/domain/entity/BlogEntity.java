package com.example.blog_jpa.blog.domain.entity;

import com.example.blog_jpa.user.domain.entity.UserEntity;

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
@Table(name = "JPA_BLOG_TBL") // 테이블의 네이밍 가능, 없이 사용하면 class명이 테이블명이 됨
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = true, length = 1000)
    private String content;

    // 외래키 설정 :entity 끼리의 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    private UserEntity author;

}