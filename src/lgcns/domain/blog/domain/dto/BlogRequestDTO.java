package lgcns.domain.blog.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Setter
@Getter
public class BlogRequestDTO {
    private int id; // 게시글을 식별할 수 있는 유일한 값(pk(primary key): not null + unique)
    private String title, content, writer;

    // 정적 팩토리 메서드 패턴(static factory method pattern)
    public static BlogResponseDTO toResponseDTO(BlogRequestDTO blogRequestDTO){
        return BlogResponseDTO.builder()
                                .id(blogRequestDTO.id)
                                .title(blogRequestDTO.title)
                                .content(blogRequestDTO.content)
                                .writer(blogRequestDTO.writer)
                                .build();
    }
}
