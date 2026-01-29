package com.example.blog_jpa.common.health.domain.dto;

import com.example.blog_jpa.common.health.domain.entity.HealthEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HealthResponseDTO {
    private Long id;
    private String message;

    public static HealthResponseDTO fromEntity(HealthEntity healthEntity){
        return HealthResponseDTO.builder()
                                .id(healthEntity.getId())
                                .message(healthEntity.getMessage())
                                .build();
    }
}
