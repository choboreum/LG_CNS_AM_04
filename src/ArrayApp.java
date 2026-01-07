public class ArrayApp {
    public static void main(String[] args) {
        boolean [] ary = new boolean[10];
        ary[1] = true;
        for(int i = 0; i < ary.length; i++){ //외부순환자의 문법
            System.out.println(ary[i]);
        }

        System.out.println("================================");

        // enhanced loop
        for(boolean data : ary){ //내부순환자의 문법 - 따로 첨자번지를 작성하지 않고 배열에서 가져와서 돌리도록 함
            System.out.println(data);
        }
    }
}
