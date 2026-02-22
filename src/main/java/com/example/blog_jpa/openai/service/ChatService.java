package com.example.blog_jpa.openai.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.blog_jpa.openai.domain.ChatResponseDTO;
import com.example.blog_jpa.openai.domain.QuizResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

// open api 2 gen endpoint
@Service
@RequiredArgsConstructor
public class ChatService {
    @Value("${spring.ai.openai.model}")
    private String model;
    @Value("${spring.ai.openai.api.key}")
    private String key;
    @Value("${spring.ai.openai.api.url}")
    private String url;

    private OkHttpClient okHttpClient = new OkHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();
    // chatbot
    private RestTemplate restTemplate = new RestTemplate();

    public ChatResponseDTO recommend(String weather, String location){
        System.out.println(">>>> ChatService recommend()");
        System.out.println(" param weather : " + weather);
        System.out.println(" param location : " + location);
        System.out.println(" model : " + model);
        System.out.println(" key : " + key);
        System.out.println(" url : " + url);

        String prompt = """
            너는 멋진 인공지능이고, 맛집 추천 전문가야.
            오늘 날씨에 적합한 맛있는 음식점을 추천해줘.
            아래 규칙을 반드시 지켜줘.
            1. 무조건 json 형식으로 대답해.
            2. 다른 문장이나 설명없이 json으로만 출력해.
            조건 : 
            - 날씨 : "%s"
            - 위치 : "%s"
            출력 예시)
            {
                "weather" : "<날씨>", 
                "location" : "<위치>",
                "restaurants" : [
                    {
                        "name" : "<음식점명>",
                        "category" : "<분류>",
                        "reason" : "<추천 이유>"
                    }
                ]
            }
        """.formatted(weather, location);

        /*
        - endpoint : 메세지 대화 형식에 대한 이해
        messages{
            Map -{
                role : system, user, assistant
                content : xxxx
            }
        }
        */
        Map<String, Object> systemRole = new HashMap<>();
        systemRole.put("role", "system");
        systemRole.put("content", "너는 맛집 추천 전문가야");

        Map<String, Object> userRole = new HashMap<>();
        userRole.put("role", "user");
        userRole.put("content", prompt);

        /* 
        // 대화를 이어 나갈 경우 사용
        Map<String, Object> assistantRole = new HashMap<>();
        assistantRole.put("role", "user");
        assistantRole.put("content", null);
        */

        Map<String, Object> message = new HashMap<>();
        message.put("model", model);
        message.put("messages", List.of(systemRole, userRole));

        // Object -> json
        String requestJson = null;
        try {
            requestJson = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(">>>> [ChatResponseDTO] requestJson : " + requestJson);   

        Request request = new Request.Builder()
                                    .url(url)
                                    .header("Authorization", "Bearer " + key)
                                    .header("Content-Type", "application/json")
                                    .post(RequestBody.create(requestJson, MediaType.parse("application/json")))
                                    .build();


        Response response = null;
        String responseJson = null;
        try {
            response = okHttpClient.newCall(request).execute();
            System.out.println(">>>> [ChatResponseDTO] response : " + response);
            
            responseJson = response.body().string();
            System.out.println(">>>> [ChatResponseDTO] responseJson : " + responseJson);
            
            JsonNode node = objectMapper.readTree(responseJson);
            System.out.println(">>>> [ChatResponseDTO] node : " + node);
            
            String exr = node.at("/choices/0/message/content")//choices는 배열이기 때문에 인덱스가 필요
                            .asText();
            System.out.println(">>>> [ChatResponseDTO] exr : " + exr);
                
            return objectMapper.readValue(exr, ChatResponseDTO.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return null;
    }

    public QuizResponseDTO question(String subject){
        System.out.println(">>>> ChatService question()");
        System.out.println(" param : " + subject);

        String prompt = """
            너는 멋진 인공지능이고, 국가공인 문제 출제 위원 전문가야.
            너의 전공 분야는 %s 문제 출제 전공이야.
            아래 규칙을 반드시 지켜줘.
            1. 무조건 json 형식으로 대답해.
            2. 다른 문장이나 설명없이 json으로만 출력해.
            3. 3개 퀴즈문제를 만들어야해
            4. ` 쓰지마

            출력 예시)
            {
                "quiz" : [
                    {
                        "question" : "<문제내용>",
                        "option" : ["<보기1>","<보기2>","<보기3>","<보기4>"],
                        "answer" : "<정답>",
                        "desc" : "<해설>"
                    }
                ]
            }
        """.formatted(subject);

        Map<String, Object> systemRole = new HashMap<>();
        systemRole.put("role", "system");
        systemRole.put("content", "너는 국가공인 문제 출제 위원 전문가야");

        Map<String, Object> userRole = new HashMap<>();
        userRole.put("role", "user");
        userRole.put("content", prompt);

        Map<String, Object> message = new HashMap<>();
        message.put("model", model);
        message.put("messages", List.of(systemRole, userRole));

        String requestJson = null;
        try{
            requestJson = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(">>>> [QuizResponseDTO] requestJson : " + requestJson);
        
        Request request = new Request.Builder()
                                    .url(url)
                                    .header("Authorization", "Bearer "+key)
                                    .header("Content-Type", "application/json")
                                    .post(RequestBody.create(requestJson, MediaType.parse("application/json")))
                                    .build();
        Response response = null;
        String responseJson = null;
        try{
            response = okHttpClient.newCall(request).execute();
            System.out.println(">>>> [QuizResponseDTO] response : " + response);
            responseJson = response.body().string();
            System.out.println(">>>> [QuizResponseDTO] responseJson : " + responseJson);
            
            JsonNode node = objectMapper.readTree(responseJson);
            String exr = node.at("/choices/0/message/content").asText();
            System.out.println(">>>> [QuizResponseDTO] exr : " + exr);

            return objectMapper.readValue(exr, QuizResponseDTO.class);

        } catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public String chatbot(String message){
        System.out.println(">>>> chatbot service message");
        System.out.println(" param : " + message);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(key);
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        
        // Response API Body
        Map<String, Object> body = Map.of(
            "model", model,
            "messages", List.of(
                Map.of("role", "system", "content", "your role is a helpful assistant"),
                Map.of("role", "user", "content", message)
            )
        );
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        
        // open ai 요청
        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);
        
        // 응답 추출
        System.out.println(">>>> response : " + response);
        List<Map<String, Object>> choices = (List<Map<String, Object>>)response.getBody().get("choices");

        //content 추출
        Map<String, Object> msg = (Map<String, Object>)choices.get(0).get("message");
        return (String)msg.get("content");
    }
}
