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

    /** 
     * 매개변수의 값은 1~3
     * 1. 1 선택 시 => false!
     * 2. 2 선택 시 => false false!
     * 3. 3 선택 시 => true~~
     */
    public String woodMan(int num){
        String str = null;

        if(num < 4 && num > 0){
            if(num == 1) str = "false!";
            else if(num == 2) str = "false false!";
            else str = "true~~";
        } else{
            str = "1~3사이로 작성해주세요.";
        }

        return str;
    }
}
