package pl.kordecki.quoter.service.api;

import pl.kordecki.quoter.model.Quote;

import java.util.List;

public interface QuoteServiceAPI {
    public void addNewQuote(Quote quote);

    List<Quote> getAllQuotes();
}
