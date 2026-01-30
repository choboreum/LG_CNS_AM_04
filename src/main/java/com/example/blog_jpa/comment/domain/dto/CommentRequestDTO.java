package com.example.blog_jpa.comment.domain.dto;

import com.example.blog_jpa.blog.domain.entity.BlogEntity;
import com.example.blog_jpa.comment.domain.entity.CommentEntity;
import com.example.blog_jpa.user.domain.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDTO {
    private String content;
    private Integer blogId;

    public CommentEntity toEntity(BlogEntity blogEntity){
        return CommentEntity.builder()
                        .content(this.content)
                        .blog(blogEntity)
                        .build();
    }
}