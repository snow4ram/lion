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


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorPostingService {

    @Autowired
    private final AuthorInformationJpaRepository repository;

    @Transactional
    public Author save(AuthorRequestDto requestDto) {
        if (requestDto == null) {
            throw new IllegalArgumentException("값이 null 입니다.");
        }
        return repository.save(requestDto.authorEntity());
    }

    @Transactional
    public void update(Long id, AuthorUpdateRequestDto updateRequestDto) {

        Author author = repository.findById(id).orElseThrow();

        author.update(updateRequestDto.getWise_saying(), updateRequestDto.getWriter());
    }

    @Transactional
    public Author findWriter(Long findWriter) {
        return repository.findById(findWriter).orElseThrow();
    }

    @Transactional
    public void findTextDelete(Long findText) {
        repository.deleteById(findText);
    }

    @Transactional
    public List<Author> findAll() {
        return new ArrayList<>(repository.findAll());
    }





}
