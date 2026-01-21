package com.example.am_spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.am_spring.user.dao.UserMapper;
import com.example.am_spring.user.domain.dto.UserRequestDTO;
import com.example.am_spring.user.service.UserService;

@SpringBootTest
public class MybatisAppTests {
    @Autowired
    // step01.
    // private UserMapper userMapper;

    // step02.
    private UserService userService;

	@Test
	public void userInsert() {

        UserRequestDTO userRequestDTO = UserRequestDTO.builder()
                                                    .email("email@service.com")
                                                    .password("inspire")
                                                    .name("cns")
                                                    .build();
        
        /* 
        // step01.
        System.out.println(">>>>> mapper address" + userMapper);
        userMapper.insertRow(userRequestDTO);
        */

        // step02.
        System.out.println(">>>>> mapper address" + userService);
        userService.insert(userRequestDTO);
    }
}
