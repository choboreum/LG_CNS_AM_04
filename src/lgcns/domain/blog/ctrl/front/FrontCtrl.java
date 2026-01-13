package lgcns.domain.blog.ctrl.front;

import lgcns.domain.blog.ctrl.BlogInsertCtrl;
import lgcns.domain.blog.factory.BlogFactory;

public class FrontCtrl {
    private BlogFactory factory;

    public FrontCtrl(){
        factory = BlogFactory.getInstance();
    }

    public int insert(String requestPath, String title, String content, String writer){
        System.out.println(">>>> facfory insert");
        BlogInsertCtrl blogInsertCtrl = (BlogInsertCtrl)factory.getBlogBean(requestPath);

        return blogInsertCtrl.insert(null);
    }
}
