package net.illay.libraryProject.bookService.service;

import net.illay.libraryProject.bookService.model.GenreDTO;

import java.util.List;

public interface GenreService {

    GenreDTO getById(Long id);
    GenreDTO update(GenreDTO genreDTO);
    void save(GenreDTO genreDTO);
    void delete(Long id);
    List<GenreDTO> getAll();
}
