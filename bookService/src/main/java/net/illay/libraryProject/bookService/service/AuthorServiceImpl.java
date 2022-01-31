package net.illay.libraryProject.bookService.service;


import net.illay.libraryProject.bookService.entity.Author;
import net.illay.libraryProject.bookService.exception.EntityNotFoundException;
import net.illay.libraryProject.bookService.logging.LogEntryExit;
import net.illay.libraryProject.bookService.mappers.AuthorMapper;
import net.illay.libraryProject.bookService.model.AuthorDTO;
import net.illay.libraryProject.bookService.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookService bookService;

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    public AuthorDTO getById(Long id) {
        if (authorRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Author by id: " + id + " not found");
        }
        return AuthorMapper.INSTANCE.toDto(authorRepository.findById(id).get());
    }

    @LogEntryExit(showArgs = true, showResult = false, unit = ChronoUnit.MILLIS)
    public void save(AuthorDTO authorDTO) {
        Author author = AuthorMapper.INSTANCE.toEntity(authorDTO);
        authorRepository.save(author);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    public AuthorDTO update(AuthorDTO authorDTO) {
        Author author = AuthorMapper.INSTANCE.toEntity(authorDTO);
        return AuthorMapper.INSTANCE.toDto(authorRepository.save(author));
    }

    @LogEntryExit(showArgs = true, showResult = false, unit = ChronoUnit.MILLIS)
    public void delete(Long id) {
        if (authorRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Author by id: " + id + " not found");
        }
        authorRepository.deleteById(id);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    public List<AuthorDTO> getAll() {
        if (authorRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Cards not found");
        }
        return AuthorMapper.INSTANCE.map(authorRepository.findAll());
    }
}
