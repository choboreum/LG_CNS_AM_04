package lgcns.domain.blog.dao;

import lgcns.domain.blog.domain.dto.BlogRequestDTO;
import lgcns.domain.blog.service.BlogService;
import lombok.Builder;

/**
 *  Mybatis 이용한 db작업을 전담하는 객체
 * @Mapper
 */

@Builder
public class BlogMapper { 
    /**
     * 매개변수로 전달되는 객체정보를 꺼내서 테이블에 입력하는 구문
     * SQL(Structure Query Language)
     * - insert into table_name values(id, ?, ?, ?);
     */
    public int insert(BlogRequestDTO blogRequestDTO){
        System.out.println(">>>> BlogMapper");
        int result = 0;
        BlogService blogService = BlogService.builder().build();
        result = blogService.insert(blogRequestDTO);
        return result;
    }
    
}