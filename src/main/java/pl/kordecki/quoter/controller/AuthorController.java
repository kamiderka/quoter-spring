package pl.kordecki.quoter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kordecki.quoter.service.api.AuthorServiceAPI;
import pl.kordecki.quoter.service.api.QuoteServiceAPI;

@Controller
public class AuthorController {

    private final AuthorServiceAPI authorService;

    @Autowired
    public AuthorController(AuthorServiceAPI authorService) {
        this.authorService = authorService;
    }


    @GetMapping("/authors")
    public String authors(Model model){

        model.addAttribute("authorsList", authorService.getAuthors());

        return "authors";
    }

}