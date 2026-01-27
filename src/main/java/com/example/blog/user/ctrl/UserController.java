package com.example.blog.user.ctrl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.blog.domain.dto.BlogRequestDTO;
import com.example.blog.service.BlogService;
import com.example.blog.user.domain.dto.UserRequestDTO;
import com.example.blog.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name="Blog user API", description = "Blog 사용자 생성 및 로그인 관련 API 명세서")
public class UserController {
    
    // Service 의존성 주입
    private final UserService userService;

    // join
    // status code: 201
    @ApiResponses(
        {
            @ApiResponse(responseCode = "201", description = "데이터 입력 성공"),
            @ApiResponse(responseCode = "400", description = "데이터 입력 실패")
        }
    )
    @Operation(
        summary = "회원가입",
        description = "신규 회원가입(email, password, name)"
    )
    @PostMapping("/join") 
    public ResponseEntity<Void> join(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "사용자 가입 DTO",
            required = true,
            content = @Content(
                schema = @Schema(implementation = UserRequestDTO.class)
            )
        ) @RequestBody UserRequestDTO userRequestDTO){ //json을 dto로 변환
        System.out.println(">>>> BlogController join() \n    userRequestDTO : " + userRequestDTO);

        return null;
    }

    // login
    // status code: 201
    @ApiResponses(
        {
            @ApiResponse(responseCode = "201", description = "데이터 입력 성공"),
            @ApiResponse(responseCode = "400", description = "데이터 입력 실패")
        }
    )
    @Operation(
        summary = "로그인",
        description = "로그인(email, password)"
    )
    @GetMapping("/login") 
    public ResponseEntity<Void> login(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "사용자 로그인 DTO",
            required = true,
            content = @Content(
                schema = @Schema(implementation = UserRequestDTO.class)
            )
        ) @RequestBody UserRequestDTO userRequestDTO){ //json을 dto로 변환
        System.out.println(">>>> BlogController login() \n    userRequestDTO : " + userRequestDTO);

        return null;
    }

}
