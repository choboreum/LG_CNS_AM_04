package lgcns.domain.blog.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lgcns.domain.blog.domain.dto.BlogRequestDTO;
import lgcns.domain.blog.domain.dto.BlogResponseDTO;
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
        System.out.println(">>>> BlogMapper insert");
        int result = 1; //저장이 되었다는 스위치 전달
        blogRequestDTO.setId(blogs.size()+1);
        blogs.add(blogRequestDTO);
        return result;
    }
    
    public List<BlogResponseDTO> list(){
        System.out.println(">>>> BlogMapper list");

        List<BlogResponseDTO> result = blogs.stream()
                                            /* .map(dto -> new BlogResponseDTO(
                                                dto.getTitle(),
                                                dto.getContent(),
                                                dto.getWriter()
                                            )) */
                                            .map(BlogRequestDTO::toResponseDTO)
                                            .toList();
        return result;
    }
    
    public List<BlogResponseDTO> search(String writer){
        System.out.println(">>>> BlogMapper writer");

        List<BlogResponseDTO> result = blogs.stream()
                                            .filter(dto -> dto.getWriter().equals(writer))
                                            .map(BlogRequestDTO::toResponseDTO)
                                            .toList();
        return result;
    }

    public Optional<BlogResponseDTO> read(int id){
        System.out.println(">>> BlogMapper read");

        Optional<BlogResponseDTO> result = blogs.stream()
                                                .filter(dto -> dto.getId() == id)
                                                .map(BlogRequestDTO::toResponseDTO)
                                                .findFirst();

        return result;
    }

    public int delete(int id){
        System.out.println(">>> BlogMapper delete");

        /* 
        boolean deleteFlag = blogs.stream()
            .filter(dto -> dto.getId() != id)
            .toList();
        */

        boolean deleteFlag = blogs.removeIf(dto -> dto.getId() == id);
        if(deleteFlag) return 1;
        else return 0;
    }
}