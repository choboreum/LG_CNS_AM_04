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
        }
        System.out.println(">>> end");
    }
}
