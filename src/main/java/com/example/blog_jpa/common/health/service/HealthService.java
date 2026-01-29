package com.example.blog_jpa.common.health.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog_jpa.common.health.dao.HealthRepository;
import com.example.blog_jpa.common.health.domain.dto.HealthResponseDTO;
import com.example.blog_jpa.common.health.domain.entity.HealthEntity;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class HealthService {

    private final HealthRepository healthRepository;
    public HealthResponseDTO create() {
        //insert~
        HealthEntity healthEntity = healthRepository.save(HealthEntity.builder().message("ok").build());

        HealthResponseDTO healthResponseDTO = HealthResponseDTO.fromEnitity(healthEntity);
        return healthResponseDTO;
    }

    public HealthResponseDTO read(){
        //Optional<HealthEntity> find = healthRepository.findById(1L);
        
        // 옵셔널로 받지 않을때 아래와 같이 사용 가능, entity로 접근 
        HealthEntity healthEntity = healthRepository.findById(1L) //findby기본키
                                                    .orElseThrow(()-> new RuntimeException("Read Fail"));

        HealthResponseDTO healthResponseDTO = HealthResponseDTO.fromEnitity(healthEntity);
        return healthResponseDTO;
    }

    public HealthResponseDTO update(){
        //Optional<HealthEntity> find = healthRepository.findById(1L);
        
        // 옵셔널로 받지 않을때 아래와 같이 사용 가능, entity로 접근 
        HealthEntity healthEntity = healthRepository.findById(1L) //findby기본키
                                                    .orElseThrow(()-> new RuntimeException("Read Fail"));

        /* 
        // HealthEnitity.java에 @Setter가 없을 경우
        HealthEntity updated = healthEntity.builder()
                                            .id(healthEntity.getId())
                                            .message("fail")
                                            .build();
        healthRepository.save(updated);
        */

        healthEntity.setMessage("fail");
        HealthEntity result = healthRepository.save(healthEntity);
        HealthResponseDTO healthResponseDTO = HealthResponseDTO.fromEnitity(result);
        return healthResponseDTO;
    }
    
    public boolean delete(){
        /* 
        HealthEntity healthEntity = healthRepository.findById(1L) //findby기본키
                                                    .orElseThrow(()-> new RuntimeException("Read Fail"));
        healthRepository.deleteById(healthEntity.getId());
        */

        healthRepository.deleteById(2L); // 아래 코드 한줄로 두 세줄과 동일한 기능이 구현된다.
                                            // delete를 하기 위해선 select(findbyid)먼저 실행 후 delete가 됨을 알 수 있다

        return true;
    }
}
