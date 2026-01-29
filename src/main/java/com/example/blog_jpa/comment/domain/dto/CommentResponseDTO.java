package com.example.blog_jpa.comment.domain.dto;

import com.example.blog_jpa.comment.domain.entity.CommentEntity;

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
public class CommentResponseDTO {
    private Integer commentId;
    private String content;
    private Integer blogId;

    public static CommentResponseDTO fromEntity(CommentEntity commentEntity){
        return CommentResponseDTO.builder()
                                .commentId(commentEntity.getCommentId())
                                .content(commentEntity.getContent())
                                .blogId(commentEntity.getBlog().getBlogId())
                                .build();
    }
}