package com.example.blog.blog.domain.dto;

import java.util.List;

import com.example.blog.comment.domain.dto.CommentResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BlogResponseDTO {
    private Integer blogId;
    private String title, content, email;

    //////////////////////////////// 1:N
    private List<CommentResponseDTO> comments;
}
