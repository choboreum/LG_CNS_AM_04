package lgcns.domain.blog.ctrl;

import java.util.Optional;

import lgcns.domain.blog.domain.dto.BlogRequestDTO;
import lgcns.domain.blog.domain.dto.BlogResponseDTO;
import lgcns.domain.blog.service.BlogService;

public class BlogReadCtrl {
    private BlogService blogService;

    public BlogReadCtrl(){
        blogService = new BlogService();
    }

    public BlogReadCtrl(BlogService blogService){
        this.blogService = blogService;
    }
    public Optional<BlogResponseDTO> read(int id){
        System.out.println(">>>> BlogReadCtrl");
        
        return blogService.read(id);
    }
}
