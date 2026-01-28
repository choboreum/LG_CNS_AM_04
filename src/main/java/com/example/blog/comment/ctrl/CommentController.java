package com.example.blog.comment.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.blog.domain.dto.BlogRequestDTO;
import com.example.blog.comment.domain.dto.CommentRequestDTO;
import com.example.blog.comment.domain.dto.CommentResponseDTO;
import com.example.blog.comment.service.CommentService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/blogs/comments")
@RequiredArgsConstructor
@Tag(name="Blog Comments API", description = "Blog 댓글 관련 API 명세서")
public class CommentController {
    
    // 의존성 주입을 필요로 (CommentService)
    private final CommentService commentService;

    // action : CRUD
    // http://ip:port/blogs/comments/xxxxx

    @PostMapping("/write")
    public ResponseEntity<List<CommentResponseDTO>> write(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "블로그댓글 작성 요청 DTO",
            required = true,
            content = @Content(
                schema = @Schema(implementation = CommentRequestDTO.class)
            )
        ) @RequestBody CommentRequestDTO commentRequestDTO) {
        
            System.out.println(">>> CommentController path :/ write ");
            System.out.println(">>> params : " + commentRequestDTO);

            List<CommentResponseDTO> list = commentService.write(commentRequestDTO);
            // if(list.size() != 0){
            //     return ResponseEntity.status(HttpStatus.CREATED).body(list);
            // } else {
            //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            // }

            //Stream API
            return Optional.ofNullable(list)
                            .filter(lst -> !lst.isEmpty())
                            .map(lst -> ResponseEntity.status(HttpStatus.CREATED).body(lst))
                            .orElseGet(() -> 
                                {return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);}
                            );
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Object> delete(@PathVariable("commentId") Integer commentId){
        System.out.println(">>> CommentController path :/ delete ");
        System.out.println(">>> params : " + commentId);

        int flag = commentService.delete(commentId);

        return Optional.of(flag)
                        .filter(f -> f != 0) // flag -> flag != 0
                        .map(f -> ResponseEntity.status(HttpStatus.NO_CONTENT).build())
                        .orElseGet(() -> 
                            {return ResponseEntity.status(HttpStatus.NO_CONTENT).build();}
                        );
    }
}
