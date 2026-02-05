package com.example.blog_jpa.openai.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_jpa.openai.domain.ChatResponseDTO;
import com.example.blog_jpa.openai.service.ChatService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/openai")
@RequiredArgsConstructor
public class ChatController {
    
    private final ChatService chatService;

    @PostMapping("/chat")
    public ResponseEntity<ChatResponseDTO> chat(@RequestParam(name="weather") String weather, 
                        @RequestParam(name="location") String location) {
        System.out.println("ChatController chat");
        chatService.recommend(weather, location);
        
        return ResponseEntity.ok().body(chatService.recommend(weather, location));
    }
    
}
