package pl.kordecki.quoter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kordecki.quoter.model.Quote;
import pl.kordecki.quoter.service.api.QuoteServiceAPI;

@Controller
public class QuoteController {

    private final QuoteServiceAPI quoteService;

    @Autowired
    public QuoteController(QuoteServiceAPI quoteService) {
        this.quoteService = quoteService;
    }



    @PostMapping("/addQuote")
    public String addQuote(@ModelAttribute Quote quote, Model model) {

        System.out.println(quote);
        model.addAttribute("quoteForm", new Quote());
        quoteService.addNewQuote(quote);
        return "index";
    }

    @GetMapping("/quotes")
    public String listQuotes(Model model) {
        model.addAttribute("quotes", quoteService.getAllQuotes());
        return "quotes";
    }

}
