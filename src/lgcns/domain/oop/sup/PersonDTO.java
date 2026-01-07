package lgcns.domain.oop.sup;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class PersonDTO {
    private String name;
    private int age;
    private String address;

    public String personInfo(){
        return "name : " + name + "\nage : " + age + "\naddress : " + address;
    }
}
