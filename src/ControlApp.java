import java.util.Scanner;

import lgcns.domain.control.ControlDemo;
import lgcns.domain.user.UserRequestDto;

public class ControlApp {
    public static void main(String[] args) {
        ControlDemo controlDemo = new ControlDemo();
        controlDemo.operator();
        
        Scanner sc = new Scanner(System.in);

        System.out.println("[회원가입 폼]");
        System.out.println("============");
        System.out.print("- email : ");
        String email = sc.nextLine();
        System.out.print("- password : ");
        String password = sc.nextLine();
        System.out.print("- name : ");
        String name = sc.nextLine();

        // case01.
        //boolean flag = controlDemo.registerCase01(email, password, name);

        // case02
        UserRequestDto userRequestDto = new UserRequestDto(email, password, name); 
        boolean flag = controlDemo.registerCase02(userRequestDto);

        if(flag) System.out.println("> 정상적으로 가입 되었습니다.");
        else System.out.println("> 가입 중 문제가 생겼습니다");

        System.out.println("\n==========================");
        System.out.print("1~3사이의 숫자를 입력해주세요.");
        int num = sc.nextInt();
        String result = controlDemo.woodMan(num);
        System.out.println( result );
        
        System.out.println("\n==========================");
        System.out.print("국어 점수를 입력하세요. :");
        int ko = sc.nextInt();
        System.out.print("영어 점수를 입력하세요. :");
        int en = sc.nextInt();
        System.out.print("수학 점수를 입력하세요. :");
        int math = sc.nextInt();
        String pass = controlDemo.passOrNonPass(ko, en, math);
        System.out.println(pass);
    }
}
