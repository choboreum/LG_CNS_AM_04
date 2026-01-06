import lgcns.domain.loop.LoopDemo;

public class LoopApp {
    public static void main(String[] args) {
        LoopDemo loopDemo = new LoopDemo();

        int result = loopDemo.sumOneToTen(1,10);
        System.out.println( result );

        System.out.println( loopDemo.sumRandom() );
        int sumRandom2 = loopDemo.sumRandom2();
        System.out.printf("%d\n", sumRandom2);

        loopDemo.gugudan(2);

        loopDemo.gugudan2();
    }
}
