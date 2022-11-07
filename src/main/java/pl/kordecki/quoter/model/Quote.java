package pl.kordecki.quoter.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quote_id")
    private Integer quoteId;

    @Column(name = "quote_content")
    @NotBlank
    private String quoteContent;

    @Column(name = "quote_author")
    @NotBlank
    private String quoteAuthor;

    @Column(name = "is_quote_favourite")
    private Boolean isQuoteFavourite;



    public Quote(String quoteContent, String quoteAuthor, Boolean isQuoteFavourite) {
        this.quoteContent = quoteContent;
        this.quoteAuthor = quoteAuthor;
        this.isQuoteFavourite = isQuoteFavourite;
    }
}
