package lgcns.domain.oop.sub;

import lgcns.domain.oop.sup.PersonDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
public class TeacherDTO extends PersonDTO {
    private String subject;

    public String teaInfo(){
        return super.personInfo() + "\nsubject : " + subject;
    }
}
