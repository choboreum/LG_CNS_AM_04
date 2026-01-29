package com.example.blog_jpa.common.health.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog_jpa.common.health.dao.HealthRepository;
import com.example.blog_jpa.common.health.domain.entity.HealthEntity;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class HealthService {

    private final HealthRepository healthRepository;
    public boolean create() {
        //insert~
        healthRepository.save(HealthEntity.builder().message("ok").build());

        return true;
    }

}
