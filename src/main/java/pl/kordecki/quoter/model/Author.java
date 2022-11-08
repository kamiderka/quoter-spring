package pl.kordecki.quoter.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Author{

    @Id
    @Column(name = "author_name")
    private String authorName;

    @Column(name = "num_quotes")
    private Integer numberOfAuthorsQuotes;
    @Column(name = "fav_quotes")
    private Integer numberOfAuthorsFavourites;


}
