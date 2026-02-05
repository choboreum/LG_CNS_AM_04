package com.example.blog_jpa.openai.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true) //프로퍼티가 없으면 무시
public class ChatResponseDTO {
    private String weather;
    private String location;
    private List<Restaurans> restaurants;

    @Builder
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true) //프로퍼티가 없으면 무시
    public static class Restaurans{
        private String name;
        private String category;
        private String reason;
    }
}