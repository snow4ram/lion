package lionschool.lion.school.service;

import lionschool.lion.school.domain.Author;
import lionschool.lion.school.repository.AuthorInformationJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchService {

    @Autowired
    private final AuthorInformationJpaRepository repository;

    /*
     * 검색 기능.
     * 작성자에 이름으로 검색 기능을 구현 해보려고 합니다. 클라이언트로 부터 이름을 받으면
     * 1 : 값이 없으면 , Runtime 으로 "입력하신 이름 작성자는 없습니다." 메시지 출력
     * 2 : 값이 있을 경우. 값을 return
     * 3 : 이름에 조건이 맞지 않을 때 : 입력창에 3자 이상으로 이름을 입력해주세요
     * */
    public Long userSearch(final String user) {
        List<Author> result = repository.findAll();

        final String removeSpaces = user.trim();

        if (removeSpaces.length() < 2 || removeSpaces.isBlank()) {
            throw new IllegalArgumentException("세자리 이상 , 공백은 허용하지 않습니다.");
        }

        Optional<Long> any = result.stream()
                .filter(authors -> authors.getWriter().equals(removeSpaces))
                .map(Author::getId)
                .findAny();

        return any.orElseThrow();
    }

}
