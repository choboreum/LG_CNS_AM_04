package com.example.blog_jpa.common.health.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_jpa.common.health.domain.dto.HealthResponseDTO;
import com.example.blog_jpa.common.health.service.HealthService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/health")
@RequiredArgsConstructor
public class HealthController {
    
    private final HealthService healthService;

    @GetMapping("/create")
    public ResponseEntity<HealthResponseDTO> create() {
        System.out.println(">>>> HealthController create()");
        return ResponseEntity.status(HttpStatus.CREATED).body(healthService.create());
    }

    @GetMapping("/read")
    public ResponseEntity<HealthResponseDTO> read() {
        System.out.println(">>>> HealthController read()");
        return ResponseEntity.status(HttpStatus.OK).body(healthService.read());
    }

    @GetMapping("/update")
    public ResponseEntity<HealthResponseDTO> update() {
        System.out.println(">>>> HealthController update()");
        return ResponseEntity.status(HttpStatus.OK).body(healthService.read());
    }
    
}
