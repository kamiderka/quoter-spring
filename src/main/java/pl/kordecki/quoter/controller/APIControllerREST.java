package pl.kordecki.quoter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kordecki.quoter.model.Author;
import pl.kordecki.quoter.model.Quote;
import pl.kordecki.quoter.service.api.AuthorServiceAPI;
import pl.kordecki.quoter.service.api.QuoteServiceAPI;

import java.util.List;

@RestController
public class APIControllerREST {

    private final QuoteServiceAPI quoteService;
    private final AuthorServiceAPI authorService;

    @Autowired
    public APIControllerREST(QuoteServiceAPI quoteService, AuthorServiceAPI authorService) {
        this.quoteService = quoteService;
        this.authorService = authorService;
    }

    @GetMapping("/api/v1/quotes")
    public List<Quote> showQuotesAPI(){
        return quoteService.getAllQuotes();
    }

    @GetMapping("/api/v1/authors")
    public List<Author> showAuthorsAPI(){
        return authorService.getAllAuthors();
    }
}
