package lionschool.lion.school.web.request;

import jakarta.validation.constraints.NotBlank;


public class AuthorSearchRequestDto {

    @NotBlank
    private String name;

    public AuthorSearchRequestDto(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
