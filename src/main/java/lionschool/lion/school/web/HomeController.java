package lionschool.lion.school.web;

import lionschool.lion.school.domain.Author;
import lionschool.lion.school.service.AuthorPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    private final AuthorPostingService service;

    @GetMapping
    public String home(Model model) {
        final List<Author> all = service.findAll();
        model.addAttribute("findAll", all);
        return "index";
    }
}
