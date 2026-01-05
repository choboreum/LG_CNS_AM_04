import lgcns.domain.car.Car;

public class CarApp {
    public static void main(String[] args) {
        /**
         * Quiz )
         * Car타입의 객체 생성 후 인스턴스 소유의 maker, model,  price에 접근하여 메소드 호출
         */

        Car car = new Car("테슬라", "Model Y", 123);
        car.setMaker("아우디");
        car.setModel("A8");
        car.setPrice(456);

        String dreamCar =  car.dreamCar();
        System.out.println(dreamCar);
    }
}
