import lgcns.domain.oop.service.OopService;
import lgcns.domain.oop.sup.PersonDTO;
import lgcns.domain.oop.util.DivisionFlag;

public class OopFrontApp {
    public static void main(String[] args) {
        OopService oopService = new OopService();

        System.out.println(">>>> 객체 생성 요구");

        oopService.makePer(DivisionFlag.STU, "lg", 20, "seoul", "2026");
        oopService.makePer(DivisionFlag.TEA, "teacher", 20, "seoul", "ko");

        PersonDTO [] ary = oopService.getAry();
        for(PersonDTO data : ary){
            if(data != null) {
            System.out.println(data.personInfo());
            }
        }

        System.out.println("\n>>>>찾기");
        PersonDTO findPer = oopService.findPer("teacher");

        if(findPer != null) {
            System.out.println(findPer.personInfo());
        } else {
            System.out.println(">>> Error! not found!");
        }
    }
}
