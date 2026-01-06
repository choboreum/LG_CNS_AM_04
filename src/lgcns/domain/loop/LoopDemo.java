package lgcns.domain.loop;

public class LoopDemo {
    public int sumOneToTen(int startNum, int endNum){
        int sum = 0;

        for(int i = startNum; i <= endNum; i++){
            sum += i;
        }

        return sum;
    }

    /**
     * Quiz)
     * 1~100사이의 난수에서 1~해당 난수까지의 누적합을 반환 한다면?
     * - argument X
     * - return type : int => 난수값 보고싶어서 String으로 변경 하였음
     * - method name : sumRandom
     * 힌트, Math.random() 참고
     */
    public String sumRandom(){
        int num = (int)(Math.random() * 100) + 1;
        int sum = 0;

        System.out.println("난수 : " + num);
        // for(int i = 1; i <= num; i++){
        //     sum += i;    
        // }

        int i = 0;
        while (i <= num) {
            sum += i;    
            i++;
        }

        String result =  "난수는 : " + num + "이며, 1부터 " + num + "까지의 합은 " + sum + "입니다.";

        return result;
    }

    public int sumRandom2(){
        int num = (int)(Math.random() * 100) + 1;
        int sum = 0;

        System.out.println("난수 : " + num);
        // for(int i = 1; i <= num; i++){
        //     sum += i;    
        // }

        int i = 0;
        while (i <= num) {
            sum += i;    
            i++;
        }

        int result = sum;

        return result;
    }
}
