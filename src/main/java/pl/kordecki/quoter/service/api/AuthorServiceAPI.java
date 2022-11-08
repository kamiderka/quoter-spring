package pl.kordecki.quoter.service.api;

import java.util.List;
import pl.kordecki.quoter.model.Author;


public interface AuthorServiceAPI {
    List<Author> getAuthors();
}
