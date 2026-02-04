package com.example.blog_jpa.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /* 404 */
    @ExceptionHandler(RuntimeException.class) //RuntimeException이 service에서 터질때 핸들러가 메서드를 호출해줌
    public ResponseEntity <String> handlerNotFound(RuntimeException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    
}
