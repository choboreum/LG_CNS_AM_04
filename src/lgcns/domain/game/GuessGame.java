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
    /* 의존성 주입: Scanner를 멤버 변수로 관리하여 자원 낭비를 방지함 */
    private Scanner sc; //바로 값을 탈아도 되지만, 메서드가 호출될 때마다 매번 생성하지 않아야 하기 떄문에 객체 초기화 이후 사용을 해야한다
    public GuessGame(){ //객체가 생성이 되어야 메모리상에 로드가 되고나서 해당 scanner를 사용 할 수 있기 때문에 멤버변수로 꺼내온다
        sc = new Scanner(System.in);
    } 
    /* //의존성 주입: Scanner를 멤버 변수로 관리하여 자원 낭비를 방지함 */

    public String gameFor(int num){
        String str = null;
        boolean flag = false; // 게임 종료를 위한 확실한 키
        int cnt = 0; // 몇번 진행하였는지 카운팅
        
        System.out.println("1~100 사이의 난수를 맞춰보세요! (기회 : 10번)");
        System.out.println(">>>>>> 난수는" + num);
        
        for(int i = 1; i <=10 ; i++){
            cnt++;
            System.out.println(i + "번째 도전입니다.");
            int answer = sc.nextInt();

            if(num > answer) System.out.println("up!");
            else if(num < answer) System.out.println("down!");
            else {
                flag = true;
                break;
            }
        } 

        if(flag){
            return str = cnt + "번째 정답을 맞췄습니다.";
        } else{
            return str = "10번의 기회를 모두 사용하였습니다.";
        }
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
