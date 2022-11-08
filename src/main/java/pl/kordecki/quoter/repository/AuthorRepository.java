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
    @Query(value = "INSERT INTO quotes.author(author_name,num_quotes,fav_quotes)\n" +
            "SELECT quote_author, num_quot, fav_quot \n" +
            "FROM (SELECT quote_author, count(quote_content) AS num_quot, sum(is_quote_favourite) AS fav_quot FROM quotes.quote \n" +
            "GROUP BY quote_author) AS T1\n" +
            "ON DUPLICATE KEY UPDATE num_quotes=num_quot, fav_quotes=fav_quot", nativeQuery = true)
    void refreshAuthors();


    @Query("SELECT a FROM Author a")
    List<Author> getAuthors();
}
