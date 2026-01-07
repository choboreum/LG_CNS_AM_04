package lgcns.domain.oop.sub;

import lgcns.domain.oop.sup.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
public class StudentDTO extends PersonDTO {
    private int ssn;
    
    public String stuInfo(){
        return super.personInfo() + "\nssn : " + ssn;
    }
}
