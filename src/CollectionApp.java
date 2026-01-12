import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionApp {
    public static void main(String[] args) {
        System.out.println("array");

        int [] ary = new int[5];
        ary[0] = 10;
        ary[1] = 20;
        ary[2] = 30;
        ary[3] = 40;
        ary[4] = 50;
        System.out.println("ary.length : " + ary.length);

        ary[2] = 0;
        System.out.println(Arrays.toString(ary));

        System.out.println("\n>>> Collection API");
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list.toString());
        for(int i = 0; i < list.size(); i++){
            int data = list.get(i);
            System.out.println(data);
        }
    }
}
