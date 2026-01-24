package com.example.blog.blog.ctrl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.blog.domain.dto.BlogRequestDTO;
import com.example.blog.blog.domain.dto.BlogResponseDTO;
import com.example.blog.service.BlogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.annotation.Resource;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController //restApi 통신에서 사용, json
@RequestMapping("/blogs") //url 패턴 매핑을 통해서 controller을 찾는 과정
@RequiredArgsConstructor // final로정의된 객체를 생성자로 만들어 받는 구조
@Tag(name ="Blog API", description = "Blog API 명세서")

public class BlogController {
    
    /*
    @Resource(name = "blogService") //name 지정하여 객체 지정을 하여 객체 의존성 주입, @Autowired 대신 사용 가능
    private BlogService blogService;
    */
    private final BlogService blogService;

    // create
    // status code: 201
    @ApiResponses(
        {
            @ApiResponse(responseCode = "201", description = "데이터 입력 성공"),
            @ApiResponse(responseCode = "400", description = "데이터 입력 실패")
        }
    )
    @Operation(
        summary = "블로그 글 작성",
        description = "글을 신규로 작성한다.(title not null)"
    )
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
    public ResponseEntity<BlogResponseDTO> read(@Parameter(description = "블로그 ID", example = "1") @PathVariable("blogId") Integer blogId){
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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        }
    } 

    @GetMapping("/list")
    public ResponseEntity<List<BlogResponseDTO>> list(){
        System.out.println(">>>> BlogController list()");

        List<BlogResponseDTO> list = blogService.list();

        if(list.size() != 0){
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PutMapping("update/{blogId}")
    public ResponseEntity<Void> update(@PathVariable("blogId") Integer blogId, 
                        @RequestBody BlogRequestDTO blogRequestDTO){
        System.out.println(">>>> BlogController update() \n    blogRequestDTO : " + blogRequestDTO);

        int flag = blogService.update(blogId, blogRequestDTO);
        if(flag != 0){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
