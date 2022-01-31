package net.illay.libraryProject.bookService.controller;

import net.illay.libraryProject.bookService.logging.LogEntryExit;
import net.illay.libraryProject.bookService.model.BookDTO;
import net.illay.libraryProject.bookService.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api/bookservice/book")
public class BooksController {

    @Autowired
    private BookService bookService;

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> getBook(@PathVariable("id") Long bookId) {

        return new ResponseEntity<>(bookService.getById(bookId), HttpStatus.OK);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> saveBook(@Valid @RequestBody BookDTO bookDTO) {

        bookService.save(bookDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> updateBook(@Valid @RequestBody BookDTO bookDTO) {

        return new ResponseEntity<>(bookService.update(bookDTO), HttpStatus.OK);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> deleteCard(@PathVariable("id") Long bookId) {

        bookService.delete(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookDTO>> getAllBooks() {

        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }
}