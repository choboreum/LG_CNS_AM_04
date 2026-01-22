package com.example.blog.blog.ctrl;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.blog.domain.dto.BlogRequestDTO;
import com.example.blog.service.BlogService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.annotation.Resource;

@RestController //restApi 통신에서 사용, json
@RequestMapping(" blogs") //url 패턴 매핑을 통해서 controller을 찾는 과정
public class BlogController {
    
    @Resource(name = "blogService") //name 지정하여 객체 지정을 하여 객체 의존성 주입, @Autowired 대신 사용 가능
    private BlogService blogService;

    // status code: 201
    @PostMapping("/write") //action 매핑을 통해서 요청 작업을 수행하는 과정
    public ResponseEntity<Void> write(@RequestBody BlogRequestDTO blogRequestDTO){ //json을 dto로 변환
        System.out.println(">>>> BlogController write()" + blogRequestDTO);

        // 서비스와 연계

        //return new ResponseEntity(HttpStatusCode.OK);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
