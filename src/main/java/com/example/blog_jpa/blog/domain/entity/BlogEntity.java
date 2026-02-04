package com.example.blog_jpa.blog.domain.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.blog_jpa.comment.domain.entity.CommentEntity;
import com.example.blog_jpa.user.domain.entity.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false) //optional : null을 허용하지 않겠다라는 의미
    @JoinColumn(name = "email")
    private UserEntity author;

    /* 
    // 연관댓글 삭제 X
    @OneToMany(mappedBy = "blog", orphanRemoval = false)
    private List<CommentEntity> comments = new ArrayList<>();
    */
   
    //* 
    // 연관댓글 삭제 O
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments = new ArrayList<>();
    //*/

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}