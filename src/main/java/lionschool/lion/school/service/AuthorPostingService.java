package lionschool.lion.school.service;

import lionschool.lion.school.domain.Author;
import lionschool.lion.school.repository.AuthorInformationJpaRepository;
import lionschool.lion.school.web.request.AuthorRequestDto;
import lionschool.lion.school.web.request.AuthorUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorPostingService {

    @Autowired
    private AuthorInformationJpaRepository repository;

    public Author save(AuthorRequestDto requestDto) {

        if (requestDto == null) {
            throw new IllegalArgumentException("값을 확인해주세요");
        }

        return repository.save(requestDto.authorEntity());

    }


    @Transactional
    public Author update(Long id, AuthorUpdateRequestDto updateRequestDto) {

        Author author = repository.findById(id).orElseThrow();

        System.out.println("-------------------------update log------------------------------");
        log.info("author = {}" , author);
        System.out.println("-----------------------------------------------------------------");

        return author.update(updateRequestDto.getWriter(), updateRequestDto.getName());

    }

    public void findTextDelete(Long findText) {
        repository.deleteById(findText);
    }

    public List<Author> findAll() {
        return new ArrayList<>(repository.findAll());
    }



//    public List<Author> jsPost() {
//        return new ArrayList<>(list.values());
//    }




}
