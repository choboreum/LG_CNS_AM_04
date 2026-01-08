package lgcns.domain.oop.sup;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class PersonDTO {
    private String name;
    private int age;
    private String address;

    public String personInfo() {
        return "PersonDTO [name=" + name + ", age=" + age + ", address=" + address + "]";
    }
}
