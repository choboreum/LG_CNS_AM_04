package com.example.am_spring.user.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.am_spring.user.domain.dto.UserRequestDTO;
import com.example.am_spring.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



// user request url  : http://localhost:8080/user/**

@RestController
@RequestMapping("/user")

public class UserCtrl {
    
    @Autowired
    private UserService userService;

    // user request url  : http://localhost:8080/user/health
    @GetMapping("/health")    
    public String healthCheck(){
        System.out.println(">>>> UserCtrl healthCheck");

        return "ok";
    }

    @PostMapping("/join")
    public String join(@RequestBody UserRequestDTO userRequestDTO) {
        System.out.println(">>>> UserCtrl join" + userRequestDTO);
        userService.insert(userRequestDTO);

        return null;
    }
    
}
