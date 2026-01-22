package com.example.blog.blog.domain.dto;

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
    // private Integer blogId; // request할 경우에는 blogId가 필요없다.
    private String title, content, email;

    
}
