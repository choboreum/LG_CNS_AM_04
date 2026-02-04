package com.example.blog_jpa.user.domain.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.blog_jpa.blog.domain.entity.BlogEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 테이블을 의미
@Table(name = "JPA_USER_TBL") // 테이블의 네이밍 가능, 없이 사용하면 class명이 테이블명이 됨
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    private String email;

    @Column(unique = true, nullable = false, length = 255)
    private String password;

    private String name;
    private String role;

    @OneToMany(mappedBy = "author", orphanRemoval = false)
    private List<BlogEntity> blogs = new ArrayList<>();
}
