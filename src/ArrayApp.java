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
                                                    .build();

        String email = userResponseDto.getEmail();
        System.out.println(email);

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
    }
}
