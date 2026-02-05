package com.example.blog_jpa.openai.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.blog_jpa.openai.domain.MsgRequestDTO;
import com.example.blog_jpa.openai.domain.MsgResponseDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

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

    // webflux
    private final WebClient openWebClient; 

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
        System.out.println(" response : " + response);
        
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
            System.out.println(">>>> MsgService ask() responseJson : " + responseJson);

            return MsgResponseDTO.builder()
                                .answer(responseJson)
                                .build();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    
    // webflux version
    public Mono<MsgResponseDTO> genMsg(MsgRequestDTO msgRequestDTO){
        System.out.println(">>>> MsgService genMsg()");
        System.out.println(" msgRequestDTO : " + msgRequestDTO.getMessage());

        String prompt = """
        너는 인간의 감성을 지니고 있는 모델이야
        입력된 키워드를 가지고 멋진 환영 메시지를 만들어줘
        혹, ` 있으면 제거해 줘 
        키워드 : %s
        """.formatted(msgRequestDTO.getMessage());

        // Response API Body
        Map<String, Object> body = Map.of(
            "model", model,
            "input", prompt,
            "max_output_tokens" , 200 // 단어의 개수 
        );

        return openWebClient.post()
                            .uri("/responses")
                            .header(HttpHeaders.AUTHORIZATION, "Bearer " + key)
                            .bodyValue(body)
                            .retrieve()
                            .bodyToMono(String.class)
                            .map(this::jsonParse) //형변환
                            .map(txt -> MsgResponseDTO.builder().answer(txt).build());
    }

    public String jsonParse(String response){
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
            System.out.println(">>>> MsgService jsonParse() responseJson : " + responseJson);

            return responseJson;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
