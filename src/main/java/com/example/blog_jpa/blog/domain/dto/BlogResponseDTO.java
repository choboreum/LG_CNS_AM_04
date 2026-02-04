package com.example.blog_jpa.blog.domain.dto;

import java.util.List;

import com.example.blog_jpa.blog.domain.entity.BlogEntity;
import com.example.blog_jpa.comment.domain.dto.CommentResponseDTO;
import com.example.blog_jpa.common.health.domain.entity.HealthEntity;

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
public class BlogResponseDTO {
    
    private Integer blogId;
    private String title, content, email;

    // 단순히 blog만 반환하는 구조 : write, update, list(BlogResponseDTO) 
    public static BlogResponseDTO fromEntityWithoutComments(BlogEntity blogEntity){
        return BlogResponseDTO.builder()
                                .blogId(blogEntity.getBlogId())
                                .title(blogEntity.getTitle())
                                .content(blogEntity.getContent())
                                .email(blogEntity.getAuthor().getEmail())
                                .build();
    }

    // JPA : 블로그 + 댓글 100번 쿼리(n+1)도 해결
    // read 
    private List<CommentResponseDTO> comments;
    public static BlogResponseDTO fromEntityWithComments(BlogEntity blogEntity){
        return BlogResponseDTO.builder()
                                .blogId(blogEntity.getBlogId())
                                .title(blogEntity.getTitle())
                                .content(blogEntity.getContent())
                                .email(blogEntity.getAuthor().getEmail())
                                .comments(
                                    blogEntity.getComments()
                                            .stream()
                                            .map(CommentResponseDTO::fromEntity)
                                            .toList()
                                )
                                .build();
    }
}
