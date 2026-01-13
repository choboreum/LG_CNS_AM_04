package lgcns.domain.blog.domain.dto;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class BlogRequestDTO {
    private String title, content, writer;

    // 정적 팩토리 메서드 패턴(static factory method pattern)
    public static BlogResponseDTO toResponseDTO(BlogRequestDTO blogRequestDTO){
        return BlogResponseDTO.builder()
                                .title(blogRequestDTO.title)
                                .content(blogRequestDTO.content)
                                .writer(blogRequestDTO.writer)
                                .build();
    }
}
