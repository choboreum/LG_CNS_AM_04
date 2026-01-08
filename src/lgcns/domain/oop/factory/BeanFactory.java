package lgcns.domain.oop.factory;

import lgcns.domain.oop.LgTV;
import lgcns.domain.oop.SamsungTV;
import lgcns.domain.oop.util.TV;

public class BeanFactory {
    private static BeanFactory instance;
    private TV samsung;
    private TV lg;

    private BeanFactory(){
        samsung = SamsungTV.getInstance();
        lg = LgTV.getInstance();
    }

    public static BeanFactory getInstance(){
        if(instance == null){
            instance = new BeanFactory(); //생성자는 1번만 생성 => 싱글톤
        }

        return instance;
    }

    public TV getBrand(String brand){
        if(brand.equalsIgnoreCase("lg")) return lg;
        if(brand.equalsIgnoreCase("samsung")) return samsung;

        return null;
    }
}
