package com.example.blog.comment.domain.dto;

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
    private Integer commentId;
    private String content;
    private Integer blogId;
}
