package com.example.blog.blog.ctrl;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.blog.domain.dto.BlogRequestDTO;
import com.example.blog.blog.domain.dto.BlogResponseDTO;
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

    // create
    // status code: 201
    @PostMapping("/write") //action 매핑을 통해서 요청 작업을 수행하는 과정
    public ResponseEntity<Void> write(@RequestBody BlogRequestDTO blogRequestDTO){ //json을 dto로 변환
        System.out.println(">>>> BlogController write() \n    blogRequestDTO : " + blogRequestDTO);

        // 서비스와 연계
        int flag = blogService.write(blogRequestDTO);
        if(flag != 0){
            return new ResponseEntity<>(HttpStatus.CREATED); //201
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
    }

    // read
    /*
    // QueryString 방식
    @GetMapping("/read")
    public ResponseEntity<BlogResponseDTO> read(@RequestParam("blogId") Integer blogId){ // json화 하여 데이터를 내려줌 / pk를 받아서 식별하여 데이터를 받음
    */

    // PathVariable 방식
    @GetMapping("/read/{blogId}")
    public ResponseEntity<BlogResponseDTO> read(@PathVariable("blogId") Integer blogId){
        System.out.println(">>>> BlogController read() \n    blogId : " + blogId);

        BlogResponseDTO blogResponseDTO = blogService.read(blogId);
        
        if(blogResponseDTO != null){
            return new ResponseEntity<>(blogResponseDTO, HttpStatus.OK); //200
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        }
    }

    // delete
    @DeleteMapping("/delete/{blogId}")
    public ResponseEntity<Void> delete(@PathVariable("blogId") Integer blogId){
        System.out.println(">>>> BlogController delete() \n    blogId : " + blogId);

        int flag = blogService.delete(blogId);
        if(flag != 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //401
        }
    } 
}
