package com.example.blog_jpa;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.blog_jpa.blog.dao.BlogRepository;
import com.example.blog_jpa.blog.domain.dto.BlogRequestDTO;
import com.example.blog_jpa.blog.domain.entity.BlogEntity;
import com.example.blog_jpa.comment.dao.CommentRepository;
import com.example.blog_jpa.comment.domain.dto.CommentRequestDTO;
import com.example.blog_jpa.comment.domain.dto.CommentResponseDTO;
import com.example.blog_jpa.comment.domain.entity.CommentEntity;
import com.example.blog_jpa.user.dao.UserRepository;
import com.example.blog_jpa.user.domain.dto.UserRequestDTO;
import com.example.blog_jpa.user.domain.dto.UserResponseDTO;
import com.example.blog_jpa.user.domain.entity.UserEntity;

@SpringBootTest
public class UserBlogCommentAppTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private CommentRepository commentRepository;

    /**
     * 테스트 케이스 시나리오
     * 1. 로그인한 사용자(User) 존재
     * 2. 로그인한 사용자가 Blog 작성(코드 : author / db : email)
     * 3. Blog에 Comment 작성
     * 4. Blog 조회(Blog-User, Blog-Comment 관계 확인 필요)
     * 5. Comment 삭제
     */

    // 1. 회원가입
    @Test
    public void userCreate(){
        System.out.println(">>>> userCreate");
        
        UserRequestDTO userRequestDTO = UserRequestDTO.builder()
                                    .email("user@user.com")
                                    .password("user")
                                    .name("유저")
                                    .role("user")
                                    .build();
        UserEntity result = userRepository.save(userRequestDTO.toEntity()) ;
        System.out.println(result);
    }

    // 2. 로그인
    @Test
    public void userLogin(){
        System.out.println(">>>> userLogin");
        
        UserRequestDTO userRequestDTO = UserRequestDTO.builder()
                                    .email("admin@admin.com")
                                    .password("admin")
                                    .build();
        Optional<UserEntity> userEntity = userRepository.findByEmailAndPassword(userRequestDTO.getEmail(), userRequestDTO.getPassword());
        userEntity.map(UserResponseDTO::fromEntity)
                .ifPresent(System.out::println);
    }
    
    // 글 작성하기
    @Test
    public void createBlogWithUser(){
        System.out.println(">>>> createBlogWithUser");

        BlogRequestDTO blogRequestDTO = BlogRequestDTO.builder()
                                                        .title("jpa title")
                                                        .content("jpa content test")
                                                        .email("admin@admin.com")
                                                        .build();
        userRepository.findById(blogRequestDTO.getEmail())
                        .map(user -> BlogEntity.builder()
                                                .title(blogRequestDTO.getTitle())
                                                .content(blogRequestDTO.getContent())
                                                .author(user)
                                                .build()
                            )
                        .map(blogRepository::save)
                        .orElseThrow(() -> new RuntimeException("FK Error"));
        System.out.println(userRepository);

        System.out.println(">>>> createBlogWithUser completed"); 
    }

    @Test
    public void createComment(){
        System.out.println(">>>> createComment");

        CommentRequestDTO commentRequestDTO = CommentRequestDTO.builder()
                                                                .content("comment test")
                                                                .blogId(1)
                                                                .build();
        BlogEntity blog = blogRepository.findById(commentRequestDTO.getBlogId())
                                        .orElseThrow(() -> new RuntimeException("블로그가 존재하지 않습니다"));
        CommentEntity commentEntity = commentRepository.save(commentRequestDTO.toEntity(blog));
        System.out.println(CommentResponseDTO.fromEntity(commentEntity));
    }
}
