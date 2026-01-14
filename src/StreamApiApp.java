import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import lgcns.domain.blog.domain.dto.BlogRequestDTO;
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
        
        System.out.print(">>> Function : ");
        Function<String, Integer> function = (str) -> str.length();
        int len = function.apply("lgcns inspire");
        System.out.println(len);

        System.out.print(">>> Predicate : ");
        Predicate<String> predicate = (str) -> str.equals("lgcns");
        System.out.println(predicate.test("inspire"));
        
        System.out.print(">>> Stream Api : ");
        // String [] strAry = {"lg", "cns", "am"};
        // Stream<String[]> stream = Arrays.stream(strAry);
        List<String> brands = Arrays.asList("samsung", "lg");
        Stream<String> stream = brands.stream();
        //stream.forEach( (str) -> System.out.println(str) );
        brands.stream()
            .filter( str -> str.length() > 2)
            .sorted()
            .forEach(System.out::println);

        List<BlogRequestDTO> list = Arrays.asList(BlogRequestDTO.builder().writer("writer01").build(),
                                                BlogRequestDTO.builder().writer("writer02").build(),
                                                BlogRequestDTO.builder().writer("writer03").build());

        System.out.print(">>> map : ");
        List<String> writers = list.stream()
                                    .map(BlogRequestDTO::getWriter)
                                    .toList();
        writers.stream().forEach(System.out::println);
        
        System.out.print(">>> filter : ");
        List<BlogRequestDTO> filters = list.stream()
                                    .filter(obj -> obj.getWriter().length() > 2)
                                    .toList();
        filters.stream().forEach(System.out::println);
        
    }
}
