package net.illay.libraryProject.bookService.model;

import lombok.*;
import net.illay.libraryProject.bookService.entity.Book;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDTO {

    private Long authorId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Set<Book> books;
}
