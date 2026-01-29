package com.example.blog_jpa.blog.domain.dto;

import com.example.blog_jpa.blog.domain.entity.BlogEntity;
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

    public static BlogResponseDTO fromEntity(BlogEntity blogEntity){
        return BlogResponseDTO.builder()
                                .blogId(blogEntity.getBlogId())
                                .title(blogEntity.getTitle())
                                .content(blogEntity.getContent())
                                .email(blogEntity.getAuthor().getEmail())
                                .build();
    }
}
