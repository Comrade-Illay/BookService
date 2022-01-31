package net.illay.libraryProject.bookService.model;

import lombok.*;
import net.illay.libraryProject.bookService.entity.Book;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublisherDTO {

    private Long publisherId;
    private String publisherName;
    private String publisherAddress;
    private Set<Book> book;
}
