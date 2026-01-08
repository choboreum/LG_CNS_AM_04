import lgcns.domain.oop.sub.StudentDTO;
import lgcns.domain.oop.sub.TeacherDTO;
import lgcns.domain.oop.sup.PersonDTO;

public class OopApp {
    public static void main(String[] args) {
        PersonDTO studentDTO = StudentDTO.builder()
                                        .ssn("2026")    
                                        .name("lgcns")
                                        .age(26)
                                        .address("seoul")
                                        .build();

                                        
        PersonDTO teacherDTO = TeacherDTO.builder()
                                        .subject("ko")    
                                        .name("lgcns")
                                        .age(26)
                                        .address("seoul")
                                        .build();
                                        
        System.out.println( "========= studentDTO.personInfo =========" );
        System.out.println( studentDTO.personInfo() );
        
        System.out.println( "========= stuInfo =========" );
        //System.out.println( studentDTO.stuInfo() );

        System.out.println( "========= teaInfo =========" );
        //System.out.println( teacherDTO.teaInfo() );

        System.out.println( "==================" );
        PersonDTO[] preAry = new PersonDTO[10];
        preAry[0] = studentDTO;
        preAry[1] = teacherDTO;

        for(PersonDTO personDTO : preAry){
            //if(personDTO != null) System.out.println(personDTO.personInfo());
            if(personDTO != null) System.out.println(personDTO.getClass());
            if(personDTO != null) System.out.println("======== instanceof ========" );
            // if(personDTO instanceof StudentDTO) {
            //     System.out.println( ((StudentDTO)personDTO).stuInfo() );
            // } else {
            //     System.out.println( ((TeacherDTO)personDTO).teaInfo() );
            // }
        }
    }
}
