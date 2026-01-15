package lgcns.domain.blog.ctrl.front;

import java.util.List;
import java.util.Optional;

import lgcns.domain.blog.ctrl.BlogDeleteCtrl;
import lgcns.domain.blog.ctrl.BlogInsertCtrl;
import lgcns.domain.blog.ctrl.BlogListCtrl;
import lgcns.domain.blog.ctrl.BlogReadCtrl;
import lgcns.domain.blog.ctrl.BlogSearchCtrl;
import lgcns.domain.blog.ctrl.BlogUpdateCtrl;
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

    // 작성자 찾기
    public List<BlogResponseDTO> search(String requestPath, String writer){
        System.out.println(">>>> factory search");

        BlogSearchCtrl blogSearchCtrl = (BlogSearchCtrl)factory.getBlogBean(requestPath);
        
        return blogSearchCtrl.search(writer);
    }

    // 조회
    public Optional<BlogResponseDTO> read(String requestPath, int id){
        System.out.println(">>>> factory read");

        BlogReadCtrl blogReadCtrl = (BlogReadCtrl)factory.getBlogBean(requestPath);
        
        return blogReadCtrl.read(id);
    }

    // 삭제
    public int delete(String requestPath, int id){
        System.out.println(">>>> factory delete");

        BlogDeleteCtrl blogDeleteCtrl = (BlogDeleteCtrl)factory.getBlogBean(requestPath);
        
        return blogDeleteCtrl.delete(id);
    }

    // 수정
    public int update(String requestPath, String title, String content, int id){
        System.out.println(">>>> factory update");

        BlogUpdateCtrl blogUpdateCtrl = (BlogUpdateCtrl)factory.getBlogBean(requestPath);
        
        BlogRequestDTO blogRequestDTO = BlogRequestDTO.builder()
                                                    .id(id)
                                                    .title(title)
                                                    .content(content)
                                                    .build();
        return blogUpdateCtrl.update(blogRequestDTO);
    }
}
