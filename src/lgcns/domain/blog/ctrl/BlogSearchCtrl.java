package lgcns.domain.blog.ctrl;

import java.util.List;

import lgcns.domain.blog.domain.dto.BlogResponseDTO;
import lgcns.domain.blog.service.BlogService;
import lombok.Builder;

@Builder
public class BlogSearchCtrl {
    private BlogService blogService;

    public BlogSearchCtrl(){

    }
    public BlogSearchCtrl(BlogService blogService){
        this.blogService = blogService;
    }
    
    public List<BlogResponseDTO> search(String writer){
        System.out.println(">>>> BlogSearchCtrl");

        return blogService.search(writer);
    }
}
