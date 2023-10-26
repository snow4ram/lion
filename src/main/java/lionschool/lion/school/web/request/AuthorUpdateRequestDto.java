package lionschool.lion.school.web.request;

import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthorUpdateRequestDto {

    @NotBlank(message = "업데이트 할 값을 입력해주세요")
    private String wise_saying;

    @NotBlank(message = "업데이트 할 값을 입력해주세요")
    private String writer;

    public AuthorUpdateRequestDto(String writer, String name) {
        this.wise_saying = writer;
        this.writer = name;
    }

    public String getWise_saying() {
        return wise_saying;
    }

    public String getWriter() {
        return writer;
    }
}
