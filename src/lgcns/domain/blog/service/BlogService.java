package lgcns.domain.blog.service;

import lgcns.domain.blog.dao.BlogMapper;
import lgcns.domain.blog.domain.dto.BlogRequestDTO;
import lombok.Builder;

@Builder
public class BlogService { //db나 레퍼지토리에 데이터를 전달하는 역할과 데이터를 전달했으면 반환받는 역할까지 전담
    public int insert(BlogRequestDTO blogRequestDTO){
        System.out.println(">>>> BlogService");

        int result = 0;

        BlogMapper blogMapper = BlogMapper.builder().build();
        result = blogMapper.insert(blogRequestDTO);

        return result;
    }
}
