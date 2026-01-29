package com.example.blog_jpa.common.health.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // 테이블을 의미
@Table(name = "health_tbl") // 테이블의 네이밍 가능, 없이 사용하면 class명이 테이블명이 됨
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthEntity {
    @Id // 기본키를 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키의 값을 넣지않고 채번할 경우의 전략
    private Long id;

    private String message;
}
