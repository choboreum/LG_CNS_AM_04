import lgcns.domain.array.ArrayDemo;
import lgcns.domain.user.UserRequestDto;
import lgcns.domain.user.UserResponseDto;

public class ArrayApp {
    public static void main(String[] args) {
        boolean [] ary = new boolean[10];
        ary[1] = true;
        for(int i = 0; i < ary.length; i++){ //외부순환자의 문법
            System.out.println(ary[i]);
        }

        System.out.println("================================");

        // enhanced loop
        for(boolean data : ary){ //내부순환자의 문법 - 따로 첨자번지를 작성하지 않고 배열에서 가져와서 돌리도록 함
            System.out.println(data);
        }

        UserResponseDto userResponseDto = UserResponseDto.builder()
                                                    .email("lg@lg.cns")
                                                    .password("1234")
                                                    .name("lg")
                                                    .build();

        String user = userResponseDto.getEmail();
        System.out.println(user);

        UserResponseDto [] userAry = new UserResponseDto[10];
        userAry[0] = userResponseDto;
        for(int i = 0; i < userAry.length; i++){
            if(userAry[i] == null){
                break;
            }
            System.out.println(userAry[i].getEmail());
        }

        for(UserResponseDto data : userAry){
            if( data != null ) System.out.println(data.getEmail());
        }

        /////////////////////
        ArrayDemo arrayDemo = new ArrayDemo();
        arrayDemo.insertTable("1@naver.com", "2345", "11");
        arrayDemo.insertTable("2@daum.net", "3456", "22");
        arrayDemo.insertTable("3@nate.com", "4567", "33");

        UserRequestDto [] userAryResponseDto = arrayDemo.getUsers();
        for(UserRequestDto data : userAryResponseDto){
            if(data != null) System.out.println(data.getEmail());
        }
    }
}
