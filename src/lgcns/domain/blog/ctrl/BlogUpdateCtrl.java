package lgcns.domain.blog.ctrl;

import lgcns.domain.blog.domain.dto.BlogRequestDTO;
import lgcns.domain.blog.service.BlogService;

public class BlogUpdateCtrl {
    private BlogService blogService;

    public BlogUpdateCtrl(){

    }
    public BlogUpdateCtrl(BlogService blogService){
        this.blogService = blogService;
    }

    public int update(BlogRequestDTO blogRequestDTO){
        System.out.println(">>>> BlogUpdateCtrl");
        
        return blogService.update(blogRequestDTO);
    }
}
