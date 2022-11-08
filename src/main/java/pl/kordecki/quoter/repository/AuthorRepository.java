package pl.kordecki.quoter.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kordecki.quoter.model.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, String> {

    @Modifying
    @Transactional
    @Query(value = "REPLACE INTO quotes.author SELECT quote_author, count(quote_content) AS num_quotes, sum(is_quote_favourite) AS fav_quotes FROM quotes.quote \n" +
            "GROUP BY quote_author", nativeQuery = true)
    void refreshAuthors();


    @Query("SELECT a FROM Author a")
    List<Author> getAuthors();
}
