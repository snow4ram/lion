package lionschool.lion;

import jakarta.annotation.PostConstruct;
import lionschool.lion.school.domain.Author;
import lionschool.lion.school.repository.AuthorInformationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorDomain {

    @Autowired
    private final AuthorInformationJpaRepository repository;


    @PostConstruct
    public void init() {
        repository.save(new Author("비둘기", "구구구구ㅜ구구구ㅜ구구구구구"));
        repository.save(new Author("원숭이", "위끼끼끼끼ㅣ끼끼끼끼끼ㅣㄲ"));
        repository.save(new Author("코끼리", "뿌우우우ㅜ우우우우ㅜ우우우"));

    }

}
