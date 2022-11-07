package pl.kordecki.quoter.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.kordecki.quoter.model.Quote;

import java.util.List;

public interface QuoteRepository extends CrudRepository<Quote, Long> {

    @Query("SELECT q FROM Quote q WHERE q.quoteContent LIKE %:searchValue%")
    List<Quote> searchQuote(@Param("searchValue") String searchValue);
}
