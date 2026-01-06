package lgcns.domain.control;

import java.util.Scanner;

import lgcns.domain.user.UserRequestDto;

public class ControlDemo {
    public void operator(){
        System.out.println("반환x, 매개변수x");
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

       //if문
        if(num < 4 && num > 0){
            /* 
            if(num == 1) str = "false!";
            else if(num == 2) str = "false false!";
            else str = "true~~";
            */

            str = num == 1 ?  "false!" 
                : num == 2 ?  "false false!" 
                : "true~~";
        } else{
            str = "1~3사이로 작성해주세요.";
        } 
        /* //switch문
        switch(num){
            case 1: 
                str = "false!";
                break;
            case 2: 
                str = "false false!";
                break;
            case 3: 
                str = "true~~";
                break;
            default:
                str = "1~3사이로 작성해주세요.";
                break;
        }
        */

        return str;
    }

    /**
     * Quiz)
     * 세 과목의 점수가 각각 40점 이상 이면서
     * 평균 60점 이상이면 '합격' 아니면 불합격 
     */
    public String passOrNonPass (int ko, int en, int math) {
        String str = null;

        /*
        if(ko >= 40 && en >= 40 && math >= 40){
            if((ko + en + math) / 3 >= 60) str = "합격";
        } else str = "불합격"; 
        */

        double avg = (ko + en + math) / 3.0;
        str = ((ko >= 40 && en >= 40 && math >= 40) && (avg >= 60)) ? "합격" : "불합격";

        return str;
    }
}
