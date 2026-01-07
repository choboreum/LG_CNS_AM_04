import lgcns.domain.oop.sub.StudentDTO;
import lgcns.domain.oop.sub.TeacherDTO;

public class OopApp {
    public static void main(String[] args) {
        StudentDTO studentDTO = StudentDTO.builder()
                                        .ssn(2026)    
                                        .name("lgcns")
                                        .age(26)
                                        .address("seoul")
                                        .build();

                                        
        TeacherDTO teacherDTO = TeacherDTO.builder()
                                        .subject("ko")    
                                        .name("lgcns")
                                        .age(26)
                                        .address("seoul")
                                        .build();
                                        
        System.out.println( "========= studentDTO.personInfo =========" );
        System.out.println( studentDTO.personInfo() );
        
        System.out.println( "========= stuInfo =========" );
        System.out.println( studentDTO.stuInfo() );

        System.out.println( "========= teaInfo =========" );
        System.out.println( teacherDTO.teaInfo() );
    }
}
