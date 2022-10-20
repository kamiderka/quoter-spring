package pl.kordecki.quoter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kordecki.quoter.model.Quote;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("quoteForm", new Quote());
        return "index";
    }
}
