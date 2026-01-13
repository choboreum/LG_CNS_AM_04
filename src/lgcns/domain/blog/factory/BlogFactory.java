package lgcns.domain.blog.factory;

import java.util.HashMap;
import java.util.Map;

import lgcns.domain.blog.ctrl.BlogInsertCtrl;
import lgcns.domain.blog.ctrl.BlogListCtrl;
import lgcns.domain.blog.service.BlogService;

public class BlogFactory {
    private static BlogFactory instance;
    private Map<String, Object> map;
    private BlogService blogService;

    private BlogFactory(){
        map = new HashMap<>();
        blogService = new BlogService();
        map.put("insert", new BlogInsertCtrl(blogService));

        // 추후 각각의 컨트롤러를 추가
        map.put("list", new BlogListCtrl(blogService));
    }

    public static BlogFactory getInstance(){
        if(instance == null) instance = new BlogFactory();

        return instance;
    }

    public Object getBlogBean(String requestPath){
        return map.get(requestPath);
    }
}
