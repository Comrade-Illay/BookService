package net.illay.libraryProject.bookService.model;

import lombok.*;
import net.illay.libraryProject.bookService.entity.Author;
import net.illay.libraryProject.bookService.entity.Genre;
import net.illay.libraryProject.bookService.entity.Publisher;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    private Long bookId;
    private String titleOfBook;
    private Integer totalPages;
    private BigDecimal rating;
    private LocalDateTime publishedDate;
    private Publisher publisher;
    private Set<Genre> genres;
    private Set<Author> authors;

}
