import java.io.IOException;

import lgcns.domain.exception.ExceptionDemo;

public class ExceptionApp {
    public static void main(String[] args) {
        ExceptionDemo exceptionDemo = new ExceptionDemo(); 
        System.out.println(">>> start");
        try{
            //exceptionDemo.printAry();
            exceptionDemo.readString();
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println("예외 발생과 상관없이 실행 하는 코드");
        }
        System.out.println(">>> end");
    }
}
