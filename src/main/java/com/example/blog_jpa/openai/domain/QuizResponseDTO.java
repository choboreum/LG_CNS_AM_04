package com.example.blog_jpa.openai.domain;

import java.util.List;

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
public class QuizResponseDTO {
    private List<Quiz> quizs;
    
    @Builder
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Quiz{

        private String question;
        private List<String> options;
        private String answer;
        private String desc ;
    }
    
}
