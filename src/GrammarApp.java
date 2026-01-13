import java.util.ArrayList;
import java.util.List;

public class GrammarApp {
    public static void main(String[] args) {
        
        // 형변환(casting)
    
        byte x = 10, y = 20, z;
        z = (byte)(x + y);
        System.out.println(z);

        char a = 'A', b = 'B';
        System.out.println(a);
        System.out.println(b);
        System.out.println(a+b);

        float f = 3.12f;

        //////////////////////////////////////////////////
        
        char [] charAry = new char[1];
        charAry[0] = 100;
        
        int [] intAry = new int[1];
        intAry[0] = 'a';

        System.out.println("charAry[0] : " + charAry[0]);
        System.out.println("intAry[0] : " + intAry[0]);

        /////////////////////////////////////////////////////
        String str1 = "lg";
        String str2 = "lg";
        if(str1 == str2){
            System.out.println("> str1 == str2" + (str1 == str2));
        }
        if(str1.equals(str2)){
            System.out.println(">> str1.equals(str2)" + (str1.equals(str2)));
        }

        String str01 = new String("lg");
        String str02 = new String("lg");
        if(str01 == str02){
            System.out.println(">>> str01 == str02" + (str01 == str02));
        }
        if(str01.equals(str02)){
            System.out.println(">>>> str01.equals(str02)" + (str01.equals(str02)));
        }
        
        /////////////////////////////////////////////////////
        /// Stream API
        List<String> list = new ArrayList<>();
        list.add("lg");
        list.add("cns");
        list.add("am");
        list.add("inspire");

        /*
        List<String> result = new ArrayList<>();
        for(String data : list){
            if(data.length() >= 5){
                result.add(data.toUpperCase());
            }
        }
        */
        List<String> result = list.stream()
                                    .filter(data -> data.length() > 5)
                                    .map(String::toUpperCase)
                                    .toList();

        result.stream()
                .forEach( System.out::println );

        System.out.println(result);
    }
}
