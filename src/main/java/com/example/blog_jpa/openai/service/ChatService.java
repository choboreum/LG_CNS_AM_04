package com.example.blog_jpa.openai.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.blog_jpa.openai.domain.ChatResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class ChatService {
    @Value("${spring.ai.openai.model}")
    private String model;
    @Value("${spring.ai.openai.api.key}")
    private String key;
    @Value("${spring.ai.openai.api.url}")
    private String url;

    private OkHttpClient okHttpClient = new OkHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();

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
        System.out.println(">>>> requestJson : " + requestJson);   

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
            System.out.println(">>>> response : " + response);
            
            responseJson = response.body().string();
            System.out.println(">>>> responseJson : " + responseJson);
            
            JsonNode node = objectMapper.readTree(responseJson);
            System.out.println(">>>> node : " + node);
            
            String exr = node.at("/choices/0/message/content")//choices는 배열이기 때문에 인덱스가 필요
                            .asText();
            System.out.println(">>>> exr : " + exr);
                
            return objectMapper.readValue(exr, ChatResponseDTO.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

    
        return null;
    }
}
