package lgcns.domain.car;

public class Car {
    private String maker;
    private String model;
    private int price;

    
    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }


    public Car(String maker, String model, int price){
        this.maker = maker;
        this.model = model;
        this.price = price;
    }

    
    public String dreamCar(){
        return "maker : " + maker + ", \nmodel : " + model + ", \nprice : " + price;
    }
}
