package lgcns.domain.blog.ctrl;

import lgcns.domain.blog.service.BlogService;

public class BlogDeleteCtrl {
    private BlogService blogService;

    public BlogDeleteCtrl(){
        
    }
    public BlogDeleteCtrl(BlogService blogService){
        this.blogService = blogService;
    }

    public int delete(int id){
        System.out.println(">>>> BlogDeleteCtrl");
        
        return blogService.delete(id);
    }
}
