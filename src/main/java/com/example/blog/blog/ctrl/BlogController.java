package com.example.blog.blog.ctrl;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.blog.domain.dto.BlogRequestDTO;
import com.example.blog.service.BlogService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.annotation.Resource;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController //restApi 통신에서 사용, json
@RequestMapping("/blogs") //url 패턴 매핑을 통해서 controller을 찾는 과정
@RequiredArgsConstructor // final로정의된 객체를 생성자로 만들어 받는 구조
public class BlogController {
    
    /*
    @Resource(name = "blogService") //name 지정하여 객체 지정을 하여 객체 의존성 주입, @Autowired 대신 사용 가능
    private BlogService blogService;
    */
    private final BlogService blogService;

    // status code: 201
    @PostMapping("/write") //action 매핑을 통해서 요청 작업을 수행하는 과정
    public ResponseEntity<Void> write(@RequestBody BlogRequestDTO blogRequestDTO){ //json을 dto로 변환
        System.out.println(">>>> BlogController write()" + blogRequestDTO);

        // 서비스와 연계
        blogService.write(blogRequestDTO);

        //return new ResponseEntity(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
