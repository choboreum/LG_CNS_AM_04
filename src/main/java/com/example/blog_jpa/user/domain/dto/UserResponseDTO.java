package com.example.blog_jpa.user.domain.dto;

import com.example.blog_jpa.common.health.domain.dto.HealthResponseDTO;
import com.example.blog_jpa.common.health.domain.entity.HealthEntity;
import com.example.blog_jpa.user.domain.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String email, password, name, role;

    public static UserResponseDTO fromEntity(UserEntity UserEntity){
        return UserResponseDTO.builder()
                                .email(UserEntity.getEmail())
                                .password(UserEntity.getPassword())
                                .name(UserEntity.getName())
                                .role(UserEntity.getRole())
                                .build();
    }
}
