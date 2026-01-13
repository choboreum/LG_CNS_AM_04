package lgcns.domain.blog.ctrl;

import lgcns.domain.blog.domain.dto.BlogRequestDTO;
import lombok.Builder;

@Builder
public class BlogInsertCtrl {
    public int insert(BlogRequestDTO blogRequestDTO){
        System.out.println(">>>> BlogInsertCtrl");
        
        int result = 0;

        return result;
    }
}
