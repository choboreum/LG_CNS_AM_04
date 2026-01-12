package lgcns.domain.exception;

public class ExceptionDemo {
    private String [] strAry = {"lg", "cns", "am"};
    public void printAry() throws ArrayIndexOutOfBoundsException {
        for(int i = 0; i <= strAry.length; i++){
            System.out.println(strAry[i]);
        }
    }
}
