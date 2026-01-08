package lgcns.domain.oop;

import lgcns.domain.oop.util.TV;

public class SamsungTV implements TV {
    
    private static final SamsungTV instance = new SamsungTV();
    private SamsungTV(){

    }
    public static SamsungTV getInstance(){
        return instance;
    }

    @Override
    public void powerOn(){
        System.out.println("STV power on");
    }
    
    @Override
    public void powerOff() {
        System.out.println("STV power off");
    }
}
