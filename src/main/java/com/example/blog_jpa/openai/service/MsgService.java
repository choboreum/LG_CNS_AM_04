package com.example.blog_jpa.openai.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.blog_jpa.openai.domain.MsgRequestDTO;
import com.example.blog_jpa.openai.domain.MsgResponseDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

// open api 3 gen endpoint
@Service
@RequiredArgsConstructor
public class MsgService {
    @Value("${spring.ai.openai.model}")
    private String model;
    @Value("${spring.ai.openai.api.key}")
    private String key;
    @Value("${spring.ai.openai.api.url}")
    private String url;

    //private final RestTemplate restTemplate;
    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();

    public MsgResponseDTO ask(MsgRequestDTO msgRequestDTO){
        System.out.println(">>>> MsgService ask");
        System.out.println(" param : " + msgRequestDTO.getMessage());

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(key);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Response API Body
        Map<String, Object> body = Map.of(
            "model", model,
            "input", msgRequestDTO.getMessage()
        );

        HttpEntity<?> httpEntity = new HttpEntity<>(body, headers);
        String response = restTemplate.postForObject(url + "/responses", httpEntity, String.class);
        System.out.println(">>>> response : " + response);
        
        JsonNode node = null;
        String responseJson = null;
        try{
            node = objectMapper.readTree(response);
            responseJson = node.path("output")
                                .get(0)
                                .path("content")
                                .get(0)
                                .path("text")
                                .asText();
            System.out.println(">>>> responseJson : " + responseJson);

            return MsgResponseDTO.builder()
                                .answer(responseJson)
                                .build();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
