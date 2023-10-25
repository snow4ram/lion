package lionschool.lion.school.web.request;

import lionschool.lion.school.domain.Author;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthorRequestDto {

    private String writer;

    private String name;

    public AuthorRequestDto(String writer, String name) {
        this.writer = writer;
        this.name = name;
    }

    public Author authorEntity() {
        return Author.builder()
                .writer(getWriter())
                .name(getName())
                .build();
    }

    public String getWriter() {
        return writer;
    }

    public String getName() {
        return name;
    }
}
