package net.illay.libraryProject.bookService.service;

import net.illay.libraryProject.bookService.model.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO getById(Long id);
    BookDTO update(BookDTO bookDTO);
    void save(BookDTO bookDTO);
    void delete(Long id);
    List<BookDTO> getAll();
}
