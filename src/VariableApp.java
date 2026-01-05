import test.variable.Variable;

public class VariableApp {
    /**
     * 변수
     * 선언 위치: 전역변수, 지역변수
     * 타입: 기본, 참조
     *  => 기본: 
     *      - 숫자형
     *          - 정수 : byte, short, int, long
     *          - 실수 : float, double
     *          - 문자 : char
	 *      - 문자열 : String
     *      - 논리형 : boolean
     *  => 참조: 기본타입이 아닌 모든 것
     */
    public static void main(String[] args) {
        System.out.println("hello variable");

        int year = 2026;
        String msg = "새해입니다";
        char cha = 'F';
        boolean bool = true;
        double dou = 165.6;

        Variable instance = new Variable();
        // 참고 타입인 Variable의 변수(instance)를 생성해 
        // 생성된 객체의 주소값을 instance(변수)에 담는다.
        System.out.println(instance);
        System.out.println(instance.member);
        instance.methodTest();
    }
}
