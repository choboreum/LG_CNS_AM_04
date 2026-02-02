package com.example.blog_jpa.user.ctrl;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_jpa.blog.domain.dto.BlogRequestDTO;
import com.example.blog_jpa.user.domain.dto.UserRequestDTO;
import com.example.blog_jpa.user.domain.dto.UserResponseDTO;
import com.example.blog_jpa.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
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

        UserResponseDTO userResponseDTO = userService.join(userRequestDTO);
        if(userResponseDTO != null){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // login
    // status code: 201
    @ApiResponses(
        {
            @ApiResponse(responseCode = "200", description = "로그인 성공"),
            @ApiResponse(responseCode = "400", description = "데이터 입력 실패")
        }
    )
    @Operation(
        summary = "로그인",
        description = "로그인(email, password)"
    )
    @PostMapping("/login") 
    public ResponseEntity<UserResponseDTO> login(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "사용자 로그인 DTO",
            required = true,
            content = @Content(
                schema = @Schema(implementation = UserRequestDTO.class)
            )
        ) @RequestBody UserRequestDTO userRequestDTO){ //json을 dto로 변환
        
        Map<String, Object> map = userService.login(userRequestDTO);

        System.out.println(">>>> BlogController login() \n    body : " + (UserResponseDTO)(map.get("response")));
        System.out.println(">>>> BlogController login() \n    at : " + (String)(map.get("access")));
        System.out.println(">>>> BlogController login() \n    rt : " + (String)(map.get("refresh")));

        
        HttpHeaders headers = new HttpHeaders();
        
        headers.add("Authorization" , "Bearer " + (String)(map.get("access")) );
        headers.add("Refresh-Token", (String)(map.get("access")) );
        headers.add("Access-Control-Expose-Headers", "Authorization, Refresh-Token");
        
        return ResponseEntity.status(HttpStatus.OK)
                            .headers(headers)
                            .body((UserResponseDTO)(map.get("response")));
    }
}
