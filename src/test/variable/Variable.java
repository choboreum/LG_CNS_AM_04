package test.variable;

public class Variable {
    /**
     * 생성자 == Constructor
     * 메소드와 비슷하지만 반환타입이 없으며 메서드 이름이 반드시 클래스 이름이다.
     * [접근지정자] [메서드명(클래스명과 동일)] ([매개변수]){
     * 
     * }
     * 객체 생성시 호출되는 메서드로 전역변수를 초기화하는 역할이 대부분
     */
    public Variable(){

    }

    /**
     * - 변수 선언 문법
     *  [접근지정자] [타입] [변수명] = literal value;
     */ 
    public String member = "클래스 전역에서 사용 할 수 있는 변수";

    /**
     * - 메서드 선언 문법
     * [접근지정자] [반환 타입] [메서드명] ([매개변수]){
     * 
     * }
     */
    public void methodTest () {
        System.out.println("methodTest 실행!");
    }
}
