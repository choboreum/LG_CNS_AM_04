package lgcns.domain.blog.domain.dto;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class BlogRequestDTO {
    private String title, content, writer;
}
