package pl.kordecki.quoter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kordecki.quoter.model.Author;
import pl.kordecki.quoter.model.Quote;
import pl.kordecki.quoter.repository.QuoteRepository;
import pl.kordecki.quoter.service.api.QuoteServiceAPI;

import java.util.List;

@Service
public class QuoteService implements QuoteServiceAPI {

    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public void addNewQuote(Quote quote) {

        quoteRepository.save(quote);
    }

    @Override
    public List<Quote> getAllQuotes() {
        return (List<Quote>) quoteRepository.findAll();
    }

    @Override
    public List<Quote> searchQuote(String searchValue) {
        return quoteRepository.searchQuote(searchValue);
    }


}
