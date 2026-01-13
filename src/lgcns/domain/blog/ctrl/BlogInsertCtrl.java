package lgcns.domain.blog.ctrl;

import lgcns.domain.blog.domain.dto.BlogRequestDTO;
import lgcns.domain.blog.service.BlogService;
import lombok.Builder;

public class BlogInsertCtrl {
    private BlogService blogService;

    public BlogInsertCtrl(){
        blogService = new BlogService();
    }

    public BlogInsertCtrl(BlogService blogService){
        this.blogService = blogService;
    }
    public int insert(BlogRequestDTO blogRequestDTO){
        System.out.println(">>>> BlogInsertCtrl");
        
        /*
        int result = 0;
        result = blogService.insert(blogRequestDTO);

        return result;
        */

        return blogService.insert(blogRequestDTO);
    }
}
