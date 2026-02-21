package com.example.blog_jpa.openai.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_jpa.openai.domain.ChatResponseDTO;
import com.example.blog_jpa.openai.domain.MsgRequestDTO;
import com.example.blog_jpa.openai.domain.MsgResponseDTO;
import com.example.blog_jpa.openai.domain.QuizResponseDTO;
import com.example.blog_jpa.openai.service.ChatService;
import com.example.blog_jpa.openai.service.MsgService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/openai")
@RequiredArgsConstructor
public class ChatController {
    
    private final ChatService chatService;
    private final MsgService msgService;

    @PostMapping("/chat")
    public ResponseEntity<ChatResponseDTO> chat(@RequestParam(name="weather") String weather, 
                        @RequestParam(name="location") String location) {
        System.out.println("ChatController chat");
        chatService.recommend(weather, location);
        
        return ResponseEntity.ok().body(chatService.recommend(weather, location));
    }

    @PostMapping("/ask")
    public ResponseEntity<MsgResponseDTO> ask(@RequestBody MsgRequestDTO msgRequestDTO) {
        System.out.println("ChatController chat ask version");

        return ResponseEntity.ok().body(msgService.ask(msgRequestDTO));
    }
    
    @PostMapping("/generate")
    public Mono<MsgResponseDTO> genMsg(@RequestBody MsgRequestDTO msgRequestDTO) {
        System.out.println("ChatController chat genMsg version");

        return msgService.genMsg(msgRequestDTO);
    }
    
    @PostMapping("/quiz")
    public ResponseEntity<QuizResponseDTO> question(@RequestParam(name="subject") String subject) {
        System.out.println("ChatController chat question version");

        return ResponseEntity.ok().body(chatService.question(subject));
    }
    
}
