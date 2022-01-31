package net.illay.libraryProject.bookService.service;

import net.illay.libraryProject.bookService.model.AuthorDTO;

import java.util.List;

public interface AuthorService {

    AuthorDTO getById(Long id);
    AuthorDTO update(AuthorDTO authorDTO);
    void save(AuthorDTO authorDTO);
    void delete(Long id);
    List<AuthorDTO> getAll();
}
