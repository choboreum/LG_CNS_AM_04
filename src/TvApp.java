import lgcns.domain.oop.LgTV;
import lgcns.domain.oop.SamsungTV;
import lgcns.domain.oop.factory.BeanFactory;
import lgcns.domain.oop.util.TV;

public class TvApp {
    public static void main(String[] args) {
        /*
        TV tv = new SamsungTV();
        //TV tv = new LGTV();
        tv.powerOn();
        */

        BeanFactory beanFactory = BeanFactory.getInstance();

        TV tv = beanFactory.getBrand("lg");
        tv.powerOn();
        tv.powerOff();
    }
}
