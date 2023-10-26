package lionschool.lion.school.service.domain.author;


import lionschool.lion.school.domain.Author;
import lionschool.lion.school.repository.AuthorInformationJpaRepository;
import lionschool.lion.school.service.AuthorPostingService;
import lionschool.lion.school.web.request.AuthorRequestDto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AuthorWritingFindTest {

    @Autowired
    AuthorInformationJpaRepository jpaRepository;

    @Autowired
    AuthorPostingService service;

    @AfterEach
    void save() {
        jpaRepository.deleteAll();
    }

    @Test
    @DisplayName("글 작성자 찾기")
    public void finds() {
        Author author_1 = service.save(new AuthorRequestDto("다람쥐는 하늘을 날다", "test user A"));
        Author author_2 = service.save(new AuthorRequestDto("오리는 하늘을 날다", "test user B"));


        Author writer = service.findWriter(1L);


        Assertions.assertEquals(author_1 , writer);

    }

    @Test
    @DisplayName("글 작성자 찾지 못했을 경우")
    public void notfound() {
        Author author_1 = service.save(new AuthorRequestDto("다람쥐는 하늘을 날다", "test user A"));

        Author writer = service.findWriter(3L);


        Assertions.assertEquals(author_1 , writer);

    }
}
