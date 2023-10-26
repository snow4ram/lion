package lionschool.lion.school.web;




import lionschool.lion.school.domain.Author;
import lionschool.lion.school.service.AuthorPostingService;
import lionschool.lion.school.web.request.AuthorRequestDto;
import lionschool.lion.school.web.request.AuthorUpdateRequestDto;
import lionschool.lion.school.web.response.AuthorResponseDto;
import lionschool.lion.school.web.response.AuthorUpdateResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthorController {


    @Autowired
    private final AuthorPostingService service;

    //save
    @PostMapping("/save")
    public ResponseEntity<AuthorResponseDto> save(@RequestBody AuthorRequestDto requestDto) {

        log.info("requestDto = {}", requestDto);

        final Author save = service.save(requestDto);

        AuthorResponseDto responseDto = new AuthorResponseDto(save);

        return ResponseEntity.ok(responseDto);
    }


    @GetMapping("/find/{findId}")
    public String find (@PathVariable(name = "findId") final Long findId , Model model){

        if (findId == null) {
            throw new IllegalArgumentException("찾을시 정보에 번호를 입력해주세요");
        }

        final Author findWriter = service.findWriter(findId);

        model.addAttribute("findWriters", findWriter);

        //단일 리스트 표시
        return "";
    }

    //update
    @PatchMapping("/update/{updateId}")
    public ResponseEntity<AuthorUpdateResponseDto> update(@PathVariable Long updateId,@RequestBody @Validated AuthorUpdateRequestDto requestDto) {

        service.update(updateId, requestDto);

        Author writer = service.findWriter(updateId);

        AuthorUpdateResponseDto responseDto = new AuthorUpdateResponseDto(writer);

        //list page redirect 업데이한 상태 확인
        return ResponseEntity.ok(responseDto);
    }


    //delete
    @DeleteMapping("/delete/{findTextDelete}")
    public String delete(@PathVariable(name = "findTextDelete") final Long id) {

        service.findTextDelete(id);

        return "redirect:index";
    }

}

