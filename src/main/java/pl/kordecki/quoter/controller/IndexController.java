package pl.kordecki.quoter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import pl.kordecki.quoter.model.Quote;
import pl.kordecki.quoter.service.api.QuoteServiceAPI;

@Controller
public class IndexController {

    private final QuoteServiceAPI quoteService;

    @Autowired
    public IndexController(QuoteServiceAPI quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("quoteForm", new Quote());
        return "index";
    }

    @PostMapping("/addQuote")
    public RedirectView addQuote(@ModelAttribute Quote quote, Model model) {

        //System.out.println(quote);
        model.addAttribute("quoteForm", new Quote());
        quoteService.addNewQuote(quote);
        return new RedirectView("/");
    }

}
