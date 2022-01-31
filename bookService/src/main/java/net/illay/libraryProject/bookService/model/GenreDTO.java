package net.illay.libraryProject.bookService.model;

import lombok.*;
import net.illay.libraryProject.bookService.entity.Book;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreDTO {

    private Long genreId;
    private String genreName;
    private Set<Book> books;
}
