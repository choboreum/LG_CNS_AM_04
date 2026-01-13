package lgcns.domain.blog.ctrl;

import lgcns.domain.blog.domain.dto.BlogRequestDTO;
import lgcns.domain.blog.service.BlogService;
import lombok.Builder;

@Builder
public class BlogInsertCtrl {
    public int insert(BlogRequestDTO blogRequestDTO){
        System.out.println(">>>> BlogInsertCtrl");
        
        int result = 0;
        
        BlogService blogService = BlogService.builder().build();
        result = blogService.insert(blogRequestDTO);

        return result;
    }
}
