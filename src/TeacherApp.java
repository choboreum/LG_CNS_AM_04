import lgcns.domain.user.Teacher;

public class TeacherApp {
    public static void main(String[] args) {
        //Teacher teacher = new Teacher();
        Teacher teacher = new Teacher("cho", 30);
        
        System.out.println(teacher.name);
        System.out.println(teacher.age);
        System.out.println(teacher.mbti);
        
        // teacher.name = "cho";
        // teacher.age = 30;
        // teacher.mbti = "mbti";

        // System.out.println(teacher.name);
        // System.out.println(teacher.age);
        // System.out.println(teacher.mbti);
    }
}
