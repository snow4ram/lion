package lionschool.lion.school.web.request;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthorUpdateRequestDto {

    private String writer;

    private String name;

    public AuthorUpdateRequestDto(String writer, String name) {
        this.writer = writer;
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public String getName() {
        return name;
    }
}
