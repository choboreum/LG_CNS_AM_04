package lgcns.domain.user;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class UserResponseDto {
    // 배열에 사용자가 입력한 정보들의 묶음인 DTO의 객체를 담기 위해 어노테이션 기법으로 작성
    private String email, password, name;


}
