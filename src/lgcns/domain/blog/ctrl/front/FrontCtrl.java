package lgcns.domain.blog.ctrl.front;

import lgcns.domain.blog.factory.BlogFactory;

public class FrontCtrl {
    private BlogFactory factory;

    public FrontCtrl(){
        factory = BlogFactory.getInstance();
    }
}
