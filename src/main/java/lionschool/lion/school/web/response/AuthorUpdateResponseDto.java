package lionschool.lion.school.web.response;

import lionschool.lion.school.domain.Author;
import lombok.Getter;


@Getter
public class AuthorUpdateResponseDto {

    private final String wise_saying;

    private final String writer;

    public AuthorUpdateResponseDto(final Author author) {
        this.wise_saying = author.getWise_saying();
        this.writer = author.getWriter();
    }
}
