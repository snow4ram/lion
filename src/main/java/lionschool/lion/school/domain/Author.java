package lionschool.lion.school.domain;

import java.util.Objects;

public class Author {

    private Long id;

    private String writer;

    private String name;

    public Author(Long id, String writer, String name) {
        this.id = id;
        this.writer = writer;
        this.name = name;
    }

    public void update(final String writer, final String name) {
        if (writer.isBlank() || name.isBlank()) {
            throw new IllegalArgumentException("값을 확인해주세요");
        }

        this.writer = writer;
        this.name = name;

    }
    public String getWriter() {
        return writer;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return  " " + id + "\t" +
                " " + writer + "\t" +
                " " + name;
    }
}
