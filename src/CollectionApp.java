import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lgcns.domain.oop.sub.StudentDTO;
import lgcns.domain.oop.sub.TeacherDTO;
import lgcns.domain.oop.sup.PersonDTO;

public class CollectionApp {
    public static void main(String[] args) {
        System.out.println("array");

        int [] ary = new int[5];
        ary[0] = 10;
        ary[1] = 20;
        ary[2] = 30;
        ary[3] = 40;
        ary[4] = 50;
        System.out.println("ary.length : " + ary.length);

        ary[2] = 0;
        System.out.println(Arrays.toString(ary));

        System.out.println("\n>>> Collection API");
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list.toString());
        for(int i = 0; i < list.size(); i++){
            int data = list.get(i);
            System.out.println(data);
        }

        System.out.println(">>> DTO");
        List<PersonDTO> perList = new ArrayList<>(); //PersonDTO 타입으로 만든다는 것은, 자식도 함께 쓸 수 있다 => 다형성
        TeacherDTO teacherDTO = TeacherDTO.builder()
        .name("lgcns").age(20).address("seoul").subject("java").build();
        StudentDTO studentDTO = StudentDTO.builder()
        .name("cho").age(24).address("seoul").ssn("2026").build();
        perList.add(teacherDTO);
        perList.add(studentDTO);
        for(PersonDTO data : perList){
            System.out.println(data.personInfo());
        }
        
        System.out.println(">>> Set");
        Set<String> set = new HashSet<>();
        set.add("lg");
        set.add("cns");
        set.add("am04");
        set.add("lg");
        set.add("cns");
        set.add("am04");
        System.out.println(set);
        
        Object [] setAry = set.toArray();
        for(Object data : setAry){
            System.out.println(data);
        }

        System.out.println(">>> Map");
        Map<String, List<? extends PersonDTO>> map = new HashMap<>();

        List<PersonDTO> stuList = new ArrayList<>();
        stuList.add(studentDTO);
        List<PersonDTO> teaList = new ArrayList<>();
        teaList.add(teacherDTO);

        map.put("users", stuList);
        map.put("comment", teaList);
    }
}
