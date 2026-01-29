package com.example.blog_jpa.blog.domain.dto;

import com.example.blog_jpa.blog.domain.entity.BlogEntity;
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
public class BlogRequestDTO {
    private String title, content;
    private String email; //FK
    
    public BlogEntity toEntity(UserEntity userEntity){
        return BlogEntity.builder()
                        .title(this.title)
                        .content(this.content)
                        .author(userEntity)
                        .build();
    }
}
