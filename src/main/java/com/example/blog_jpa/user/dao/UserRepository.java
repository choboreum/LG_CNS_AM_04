package com.example.blog_jpa.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog_jpa.user.domain.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    public UserEntity findByEmailAndPassword(String email, String password);
}
