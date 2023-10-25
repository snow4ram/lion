package lionschool.lion.school.domain;


import jakarta.persistence.*;
import lionschool.lion.school.web.request.AuthorUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Entity
@Getter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String name;

    public Author() {
    }

    @Builder
    public Author(final String writer, final String name) {
        this.writer = writer;
        this.name = name;
    }

    public Author update(String update_writers , String update_name) {
        if (update_writers.isBlank() || update_name.isBlank()) {
            throw new IllegalArgumentException("값을 확인해주세요");
        }

        this.writer = update_writers;
        this.name = update_name;

        return new Author(getWriter() , getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(writer, author.writer) && Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, writer, name);
    }

    @Override
    public String toString() {
        return  "id = " + id+ "\t" +
                " writer = " + writer + "\t" +
                " name = " + name;
    }
}
