package lgcns.domain.blog.ctrl;

import java.util.List;

import lgcns.domain.blog.domain.dto.BlogRequestDTO;
import lgcns.domain.blog.domain.dto.BlogResponseDTO;
import lgcns.domain.blog.service.BlogService;
import lombok.Builder;

public class BlogListCtrl {
    private BlogService blogService;

    public BlogListCtrl(){

    }
    public BlogListCtrl(BlogService blogService){
        this.blogService = blogService;
    }
    
    public List<BlogResponseDTO> list(){
        System.out.println(">>>> BlogListCtrl");

        return blogService.list();
    }
}