import java.util.function.Consumer;
import java.util.function.Supplier;

import lgcns.domain.function.InspireFuncion;

public class StreamApiApp {
    public static void main(String[] args) {
        InspireFuncion lamdaFunc = (x,y)-> x > y ? x : y ;
        System.out.println(lamdaFunc.max(100,200));

        InspireFuncion lamdaSumFunc = (x,y)-> x + y ;
        System.out.println(lamdaSumFunc.max(100,200));
        
        System.out.print(">>> Supplier : ");
        Supplier<String> supplier = () -> "inspire";
        System.out.println(supplier.get());
        
        System.out.print(">>> Consumer : ");
        Consumer<String> consumer = (str) -> System.out.println(str.split(" ")[1]);
        consumer
            .andThen(x -> System.out.println(x))
            .accept("lgcns inspire"); 
    }
}
