import lgcns.domain.stat.StaticDemo;

public class StaticApp {
    /**
     * static 키워드가 정의된 변수 및 메서드는 클래스의 소유이다
     * 메모리의 로딩되는 시차가 발생(class 소유가 먼저 로딩-> 인스턴스 소유 로딩)
     */
    public static void main(String[] args) {
        // aryPrt();
        StaticDemo.commonUtils(); // 객체 생성 없이 바로 접근 가능

        StaticDemo staticdemo = new StaticDemo();
        staticdemo.instanceParts();
    }


    public static void aryPrt(){
        System.out.println("aryPrt() 실행");
    }
}
