package lgcns.domain.game;

import java.util.Scanner;

/**
 * 1~100사이의 난수를 발생시켜서 해당 값을 맞추는 게임
 * - 주어진 기회: 10번
 * - 사용자에게서 받은 답(Scanner사용)에서 up/down을 제공
 * - 반환값:
 *      성공) xx번째 정답을 맞췄습니다.
 *      실패) 10번의 기회를 모두 사용하였습니다.
 */
public class GuessGame {
    public String gameFor(int num){
        String str = null;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1~100 사이의 난수를 맞춰보세요! (기회 : 10번)");
        System.out.println(">>>>>> 난수는" + num);
        
        for(int i = 1; i < 11; i++){
            System.out.println(i + "번째 도전입니다.");
            int answer = sc.nextInt();
            if(num == answer){
                return str = i + "번째 정답을 맞췄습니다.";
            } else {
                if(i < 10) {
                    if(num > answer) System.out.println("up!");
                    else if(num < answer) System.out.println("down!");
                }
            } 
        } 
        return str = "10번의 기회를 모두 사용하였습니다.";
    }

    public String gameWhile(int num){
        String str = null; 
        int i = 1;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1~100 사이의 난수를 맞춰보세요! (기회 : 10번)");
        System.out.println(">>>>>> 난수는" + num);
        
        while (i>=1 && i<11) {
            System.out.println(i + "번째 도전입니다.");
            int answer = sc.nextInt();

            if(num == answer) {
                str = i + "번째에 정답을 맞추셨습니다.";
                break;
            } else {
                if(i < 10) {
                    if(num > answer) System.out.println("up!");
                    else if(num < answer) System.out.println("down!");
                }
                str = "10번의 기회를 모두 사용하였습니다.";
            }
            i++;
        }

        return str;
    }
}
