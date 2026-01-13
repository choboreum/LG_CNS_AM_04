import java.util.Scanner;

import lgcns.domain.blog.view.BlogView;

public class BlogApp {
    public static void main(String[] args) {
        BlogView blogView = BlogView.builder()
                                    .scan(new Scanner(System.in))
                                    .build();
        blogView.mainMenu();
    }
}
