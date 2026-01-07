package lgcns.domain.array;

import lgcns.domain.user.UserRequestDto;

public class ArrayDemo {
    private UserRequestDto [] userAry;

    /**
     * 매개변수로 전달된 데이터를 활용해서 UserRequestDTO 객체를 생성하고
     * 생성된 객체를 배열에 담는 코드 구현
     */
    public void insertTable(String email, String password, String name){

    }

    /**
     * Quiz)
     * 생성된 배열 정보를 반환하는 메서드 구현
     */
    public UserRequestDto [] getUsers(){ // 요소의 타입이 UserRequestDto인 [](배열)을 반환해라!
        return userAry;
    }
}
