package lgcns.domain.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionDemo {
    private String [] strAry = {"lg", "cns", "am"};
    public void printAry() throws ArrayIndexOutOfBoundsException { // 런타임시점 예외
        for(int i = 0; i <= strAry.length; i++){
            System.out.println(strAry[i]);
        }
    }

    public void readString() throws IOException { //컴파일시점 예외
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("숫자를 입력하세요 : ");
        int num = Integer.parseInt(br.readLine());
        System.out.println(num);
    }
}
