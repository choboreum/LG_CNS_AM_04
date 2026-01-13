package lgcns.domain.blog.dao;

import java.util.ArrayList;
import java.util.List;

import lgcns.domain.blog.domain.dto.BlogRequestDTO;
import lgcns.domain.blog.service.BlogService;
import lombok.Builder;

/**
 *  Mybatis 이용한 db작업을 전담하는 객체
 * @Mapper
 */

public class BlogMapper { 
    /**
     * DAO(Data Access Object) : DBMS와 CRUD 작업을 전담하는 역할
     * 매개변수로 전달되는 객체정보를 꺼내서 테이블에 입력하는 구문
     * SQL(Structure Query Language): DDL, DML, DCL, Select~
     * - insert into table_name values(id, ?, ?, ?);
     */

    private List<BlogRequestDTO> blogs;

    public BlogMapper(){
        blogs = new ArrayList<>();
    }

    public int insert(BlogRequestDTO blogRequestDTO){
        System.out.println(">>>> BlogMapper");
        int result = 1; //저장이 되었다는 스위치 전달
        blogs.add(blogRequestDTO);
        return result;
    }
    
}