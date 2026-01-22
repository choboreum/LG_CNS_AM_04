package com.example.blog.common.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController //restApi 통신에서 사용
@RequestMapping("/health") //url 패턴 매핑을 통해서 controller을 찾는 과정
public class HealthCheckController {
    
    // user endpoint : http://localhost:8080/health/alive
    @GetMapping("/alive") //action 매핑을 통해서 요청 작업을 수행하는 과정
    public String check(/* @RequestParam String param */) {
        System.out.println(">>>> HealthCheckController check()");
        return "alive";
    }
    
}
