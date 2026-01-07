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
    }
}
