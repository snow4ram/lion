package lionschool.lion.school.service.domain.author;


import lionschool.lion.school.domain.Author;
import lionschool.lion.school.repository.AuthorInformationJpaRepository;
import lionschool.lion.school.service.AuthorPostingService;
import lionschool.lion.school.web.request.AuthorRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorWritingTest {

    @Autowired
    AuthorInformationJpaRepository jpaRepository;

    @Autowired
    AuthorPostingService service;


    @AfterEach
    void delete() {
        jpaRepository.deleteAll();
    }


    @Test
    @DisplayName("작가 글 작성하기")
    public void writings() {

        //give
        String writing = "하늘을 날다";
        String writer = "test user A";

        //when
        Author author_a = service.save(new AuthorRequestDto("하늘을 날다", "test user A"));


        //then
        assertThat(author_a.getWise_saying()).isEqualTo(writing);
        assertThat(author_a.getWriter()).isEqualTo(writer);
    }




}
