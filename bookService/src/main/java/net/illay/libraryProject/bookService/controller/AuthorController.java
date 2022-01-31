package net.illay.libraryProject.bookService.controller;

import net.illay.libraryProject.bookService.logging.LogEntryExit;
import net.illay.libraryProject.bookService.model.AuthorDTO;
import net.illay.libraryProject.bookService.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api/bookservice/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable("id") Long authorId) {

        return new ResponseEntity<>(authorService.getById(authorId), HttpStatus.OK);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDTO> saveAuthor(@Valid @RequestBody AuthorDTO authorDTO) {

        authorService.save(authorDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDTO> updateAuthor(@Valid @RequestBody AuthorDTO authorDTO) {

        return new ResponseEntity<>(authorService.update(authorDTO), HttpStatus.OK);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDTO> deleteCard(@PathVariable("id") Long authorId) {

        authorService.delete(authorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {

        return new ResponseEntity<>(authorService.getAll(), HttpStatus.OK);
    }
}