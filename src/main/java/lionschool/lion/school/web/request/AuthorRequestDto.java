package lionschool.lion.school.web.request;

import jakarta.validation.constraints.NotBlank;
import lionschool.lion.school.domain.Author;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthorRequestDto {

    @NotBlank(message = "값을 입력해주세요")
    private String wise_saying;

    @NotBlank(message = "값을 입력해주세요")
    private String writer;

    @Builder
    public AuthorRequestDto(final String wise_saying,final String writer) {
        this.wise_saying = wise_saying;
        this.writer = wise_saying;
    }

    public Author authorEntity() {
        return Author.builder()
                .wise_saying(getWise_saying())
                .writer(getWriter())
                .build();
    }

    public String getWise_saying() {
        return wise_saying;
    }

    public String getWriter() {
        return writer;
    }
}
