package lgcns.domain.blog.factory;

import java.util.HashMap;
import java.util.Map;

import lgcns.domain.blog.ctrl.BlogInsertCtrl;

public class BlogFactory {
    private static BlogFactory instance;
    private Map<String, Object> map;

    private BlogFactory(){
        map = new HashMap<>();
        map.put("insert", BlogInsertCtrl.builder().build());
    }

    public static BlogFactory getInstance(){
        if(instance == null) instance = new BlogFactory();

        return instance;
    }

    public Object getBlogBean(String requestPath){
        return map.get(requestPath);
    }
}
