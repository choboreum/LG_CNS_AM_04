import java.util.Scanner;

import lgcns.domain.blog.view.BlogView;

public class BlogApp {
    public static void main(String[] args) {
        /* //Builder 방식의 참조타입 멤버변수 주입 방식
        BlogView blogView = BlogView.builder()
                                    .scan(new Scanner(System.in))
                                    .build();
        */

        //new연사자를 이용한 객체 생성 방식
        BlogView blogView = new BlogView();
        blogView.mainMenu();
    }
}
