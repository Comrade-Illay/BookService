package net.illay.libraryProject.bookService.service;

import net.illay.libraryProject.bookService.entity.Genre;
import net.illay.libraryProject.bookService.exception.EntityNotFoundException;
import net.illay.libraryProject.bookService.logging.LogEntryExit;
import net.illay.libraryProject.bookService.mappers.GenreMapper;
import net.illay.libraryProject.bookService.model.GenreDTO;
import net.illay.libraryProject.bookService.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepository genreRepository;

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    public GenreDTO getById(Long id) {
        if (genreRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Genre by id: " + id + " not found");
        }
        return GenreMapper.INSTANCE.toDto(genreRepository.findById(id).get());
    }

    @LogEntryExit(showArgs = true, showResult = false, unit = ChronoUnit.MILLIS)
    public void save(GenreDTO genreDTO) {
        Genre genre = GenreMapper.INSTANCE.toEntity(genreDTO);
        genreRepository.save(genre);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    public GenreDTO update(GenreDTO genreDTO) {
        Genre genre = GenreMapper.INSTANCE.toEntity(genreDTO);
        return GenreMapper.INSTANCE.toDto(genreRepository.save(genre));
    }

    @LogEntryExit(showArgs = true, showResult = false, unit = ChronoUnit.MILLIS)
    public void delete(Long id) {
        if (genreRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Genre by id: " + id + " not found");
        }
        genreRepository.deleteById(id);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    public List<GenreDTO> getAll() {
        if (genreRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Cards not found");
        }
        return GenreMapper.INSTANCE.map(genreRepository.findAll());
    }

}