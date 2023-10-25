package lionschool.lion.school.service.domain;

import lionschool.lion.school.domain.Author;
import lionschool.lion.school.repository.AuthorInformationJpaRepository;
import lionschool.lion.school.service.AuthorPostingService;
import lionschool.lion.school.web.request.AuthorRequestDto;
import lionschool.lion.school.web.request.AuthorUpdateRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AuthorTest {

    @Autowired
    AuthorPostingService service;

    @Autowired
    AuthorInformationJpaRepository repository;

    @Test
    public void save() {
        Author save1 = repository.save(new Author("비둘기", "날다"));
        Author save2 = repository.save(new Author("코끼리", "손"));
        Author save3 = repository.save(new Author("하마", "수박"));


    }



    @Test
    @DisplayName("저장된 값을 update 처리 테스트")
    public void update() {

        //give
        AuthorRequestDto requestDto1 = new AuthorRequestDto("test Dto 1" , "test text 1");
        AuthorRequestDto requestDto2 = new AuthorRequestDto("test Dto 2" , "test text 2");
        AuthorRequestDto requestDto3 = new AuthorRequestDto("test Dto 3" , "test text 3");

        //when
        service.save(requestDto1);
        service.save(requestDto2);
        service.save(requestDto3);



        AuthorUpdateRequestDto updateRequestDto = new AuthorUpdateRequestDto("update Dto" , "test text update");
        Author update = service.update(2L, updateRequestDto);

        //then
        Assertions.assertNotEquals(requestDto2 , update);
    }

}
