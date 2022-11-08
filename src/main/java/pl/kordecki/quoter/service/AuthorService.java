package pl.kordecki.quoter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kordecki.quoter.model.Author;
import pl.kordecki.quoter.repository.AuthorRepository;
import pl.kordecki.quoter.service.api.AuthorServiceAPI;

import java.util.List;

@Service
public class AuthorService implements AuthorServiceAPI {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAuthors() {

        authorRepository.refreshAuthors(); //Trzeba naprawić problem z REPLACE

        return authorRepository.getAuthors();
    }
}
