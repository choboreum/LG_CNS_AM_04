import lgcns.domain.function.InspireFuncion;

public class StreamApiApp {
    public static void main(String[] args) {
        InspireFuncion lamdaFunc = (x,y)-> x > y ? x : y ;
        System.out.println(lamdaFunc.max(100,200));

        InspireFuncion lamdaSumFunc = (x,y)-> x + y ;
        System.out.println(lamdaSumFunc.max(100,200));
    }
}
