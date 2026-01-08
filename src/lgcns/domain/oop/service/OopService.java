package lgcns.domain.oop.service;

import lgcns.domain.oop.sub.StudentDTO;
import lgcns.domain.oop.sub.TeacherDTO;
import lgcns.domain.oop.sup.PersonDTO;

/**
 * 배열: PersonDRO[]
 * 해당 배열에 사용자가 요구하는 StudentDTO, TeacherDTO 객체를 담을 것
 */
public class OopService {
    private PersonDTO[] perAry;
    private int i; 

    public OopService(){
        perAry = new PersonDTO[10];
    }

    // flag 1: stu
    // flag 2: tea
    public void makePer(int flag, String name, int age, String address, String comm){
        // setAry(new StudentDTO());
        // setAry(new TeacherDTO());
        PersonDTO per = null;
        // new 연산자 기법
        // per = (flag == 1) ? new StudentDTO() : new TeacherDTO(); 
        // builder 패턴 기법
        per = (flag == 1) ? StudentDTO.builder().name(name).age(age).address(address).ssn(comm)
                                .build() 
                            : TeacherDTO.builder().name(name).age(age).address(address).subject(comm)
                                .build();
        setAry(per); // 타입만 전달하는 역할
    }

    public void setAry(PersonDTO per){
        perAry[i++] = per;
    }
    
    public PersonDTO[] getAry() { // 데이터를 반환해주기 위해 생성
        return perAry;
    }
    
    public PersonDTO findPer(String name){
        PersonDTO per = null;
        for(PersonDTO data : perAry){
            if(data == null){
                break;
            } else{
                if(data.getName().equals(name)) {
                    per = data;
                }
            }
        }

        return per;
    }
}
