package lgcns.domain.control;

import java.util.Scanner;

import lgcns.domain.user.UserRequestDto;

public class ControlDemo {
    public void operator(){
        System.out.println("반환x, 매개변수x");

        Scanner sc = new Scanner(System.in);

    }

    public boolean registerCase01(String email, String password, String name){
        return true;
    }

    public boolean registerCase02(UserRequestDto userRequestDto){
        System.out.println("======= email >>> " + userRequestDto.getEmail());
        System.out.println("======= password >>> " + userRequestDto.getPassword());
        System.out.println("======= name >>> " + userRequestDto.getName());
        return true;
    }
}
