package lgcns.domain.oop;

import lgcns.domain.oop.util.TV;

public class LgTV implements TV {

    private static final LgTV instance = new LgTV();
    private LgTV(){

    }
    public static LgTV getInstance(){
        return instance;
    }

    @Override
    public void powerOn(){
        System.out.println("LGTV power on");
    }
    @Override
    public void powerOff() {
        System.out.println("LGTV power off");
    }
}
