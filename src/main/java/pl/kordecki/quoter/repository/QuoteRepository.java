package pl.kordecki.quoter.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kordecki.quoter.model.Quote;

public interface QuoteRepository extends CrudRepository<Quote, Long> {




}
