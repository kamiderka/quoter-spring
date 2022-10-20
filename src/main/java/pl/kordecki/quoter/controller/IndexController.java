package pl.kordecki.quoter.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kordecki.quoter.model.Quote;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("quoteForm", new Quote());
        return "index";
    }

    @PostMapping("/addQuote")
    public String addQuote(@ModelAttribute Quote quote, Model model){

        System.out.println(quote);
        model.addAttribute("quoteForm", new Quote());

        return "index";
    }
}
