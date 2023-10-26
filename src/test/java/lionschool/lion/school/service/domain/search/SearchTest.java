package lionschool.lion.school.service.domain.search;


import lionschool.lion.school.domain.Author;
import lionschool.lion.school.repository.AuthorInformationJpaRepository;
import lionschool.lion.school.service.SearchService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SearchTest {

    @Autowired
    AuthorInformationJpaRepository repository;

    @Autowired
    SearchService searchService;

    @BeforeEach
    void saves() {
        repository.save(new Author("test A" , "바나나"));
        repository.save(new Author("test B" , "독수리"));
        repository.save(new Author("test C" , "아이스커피"));
    }

    @Test
    @DisplayName("사용자로 부터 찾을 값 입력")
    void searchs() {

        Long aLong = searchService.userSearch("독수리");

        System.out.println(aLong);
    }


    @AfterEach
    void delete() {
        repository.deleteAll();
    }
}
