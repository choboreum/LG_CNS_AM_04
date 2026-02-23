package com.example.monolithic.user.domain.dto;

import com.example.monolithic.user.domain.entity.UserEntity;

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
    private String email, name, role;

    public static UserResponseDTO fromEntity(UserEntity UserEntity){
        return UserResponseDTO.builder()
                                .email(UserEntity.getEmail())
                                .name(UserEntity.getName())
                                .role(UserEntity.getRole())
                                .build();
    }
}
