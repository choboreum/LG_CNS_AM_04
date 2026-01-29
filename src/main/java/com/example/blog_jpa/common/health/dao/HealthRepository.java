package com.example.blog_jpa.common.health.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog_jpa.common.health.domain.entity.HealthEntity;

@Repository
public interface HealthRepository extends JpaRepository<HealthEntity, Long> {
                                    //해당 레퍼지토리가 관리하게 되는 영속성의 entity는 누구인지 명세 -> entity당 하나의 레퍼지토리가 필요하다.

}