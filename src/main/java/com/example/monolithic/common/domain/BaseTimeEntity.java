package com.example.monolithic.common.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public class BaseTimeEntity {
    
    @CreationTimestamp
    private LocalDateTime createAT;
    @CreationTimestamp
    private LocalDateTime updateAT;
    @CreationTimestamp
    private LocalDateTime deleteAT;

}
