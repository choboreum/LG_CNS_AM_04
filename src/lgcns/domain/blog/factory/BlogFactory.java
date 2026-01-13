package lgcns.domain.blog.factory;

public class BlogFactory {
    private static BlogFactory instance;
    
    private BlogFactory(){

    }

    public static BlogFactory getInstance(){
        if(instance == null) instance = new BlogFactory();

        return instance;
    }
}
