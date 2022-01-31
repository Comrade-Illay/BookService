package net.illay.libraryProject.bookService.service;

import net.illay.libraryProject.bookService.entity.Book;
import net.illay.libraryProject.bookService.exception.EntityNotFoundException;
import net.illay.libraryProject.bookService.logging.LogEntryExit;
import net.illay.libraryProject.bookService.mappers.BookMapper;
import net.illay.libraryProject.bookService.model.BookDTO;
import net.illay.libraryProject.bookService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    public BookDTO getById(Long id) {
        if (bookRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Book by id: " + id + " not found");
        }
        return BookMapper.INSTANCE.toDto(bookRepository.findById(id).get());
    }

    @LogEntryExit(showArgs = true, showResult = false, unit = ChronoUnit.MILLIS)
    public void save(BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toEntity(bookDTO);
        this.bookRepository.save(book);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    public BookDTO update(BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toEntity(bookDTO);
        return BookMapper.INSTANCE.toDto(bookRepository.save(book));
    }

    @LogEntryExit(showArgs = true, showResult = false, unit = ChronoUnit.MILLIS)
    public void delete(Long id) {
        if (bookRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Book by id: " + id + " not found");
        }
        bookRepository.deleteById(id);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    public List<BookDTO> getAll() {
        if (bookRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Cards not found");
        }
        return BookMapper.INSTANCE.map(bookRepository.findAll());
    }
}
