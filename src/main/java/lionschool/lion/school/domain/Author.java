package lionschool.lion.school.domain;


import jakarta.persistence.*;
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
    private String wise_saying;

    @Column(nullable = false)
    private String writer;

    public Author() {
    }

    @Builder
    public Author(final String wise_saying, final String writer) {
        this.wise_saying = wise_saying;
        this.writer = writer;
    }

    public void update(String update_wise_saying , String update_writer) {

        if (update_wise_saying.isBlank() || update_writer.isBlank()) {
            throw new IllegalArgumentException("값을 확인해주세요");
        }

        this.wise_saying = update_wise_saying;

        this.writer = update_writer;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(wise_saying, author.wise_saying) && Objects.equals(writer, author.writer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wise_saying, writer);
    }

    @Override
    public String toString() {
        return  "id = " + id+ "\t" +
                " wise_saying = " + wise_saying + "\t" +
                " writer = " + writer;
    }
}
