package com.example.blog_jpa.common.health.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_jpa.common.health.service.HealthService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/health")
@RequiredArgsConstructor
public class HealthController {
    
    private final HealthService healthService;

    @GetMapping("/create")
    public boolean create() {
        System.out.println(">>>> HealthController create()");
        return healthService.create();
    }
    
}
