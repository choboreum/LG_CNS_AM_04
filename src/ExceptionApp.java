import lgcns.domain.exception.ExceptionDemo;

public class ExceptionApp {
    public static void main(String[] args) {
        ExceptionDemo exceptionDemo = new ExceptionDemo(); 
        System.out.println(">>> start");
        try{
            exceptionDemo.printAry();
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println(">>> end");
    }
}
