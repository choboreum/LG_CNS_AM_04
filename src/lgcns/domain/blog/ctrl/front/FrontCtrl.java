package lgcns.domain.blog.ctrl.front;

import java.util.List;

import lgcns.domain.blog.ctrl.BlogInsertCtrl;
import lgcns.domain.blog.ctrl.BlogListCtrl;
import lgcns.domain.blog.domain.dto.BlogRequestDTO;
import lgcns.domain.blog.domain.dto.BlogResponseDTO;
import lgcns.domain.blog.factory.BlogFactory;

public class FrontCtrl {
    private BlogFactory factory;

    public FrontCtrl(){
        factory = BlogFactory.getInstance();
    }

    public int insert(String requestPath, String title, String content, String writer){
        System.out.println(">>>> facfory insert");
        BlogInsertCtrl blogInsertCtrl = (BlogInsertCtrl)factory.getBlogBean(requestPath);

        BlogRequestDTO blogRequestDTO = BlogRequestDTO.builder()
                                                    .title(title)
                                                    .content(content)
                                                    .writer(writer)
                                                    .build();
        return blogInsertCtrl.insert(blogRequestDTO);
    }

    // 전체 출력
    public List<BlogResponseDTO> list(String requestPath){
        System.out.println(">>>> factory list");

        BlogListCtrl blogListCtrl = (BlogListCtrl)factory.getBlogBean(requestPath);
    
        return blogListCtrl.list();
    }
}
