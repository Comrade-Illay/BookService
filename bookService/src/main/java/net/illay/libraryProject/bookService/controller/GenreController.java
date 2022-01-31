package net.illay.libraryProject.bookService.controller;

import net.illay.libraryProject.bookService.logging.LogEntryExit;
import net.illay.libraryProject.bookService.model.GenreDTO;
import net.illay.libraryProject.bookService.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api/bookservice/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenreDTO> getGenre(@PathVariable("id") Long genreId) {

        return new ResponseEntity<>(genreService.getById(genreId), HttpStatus.OK);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenreDTO> saveGenre(@Valid @RequestBody GenreDTO genreDTO) {

        genreService.save(genreDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenreDTO> updateGenre(@Valid @RequestBody GenreDTO genreDTO) {

        return new ResponseEntity<>(genreService.update(genreDTO), HttpStatus.OK);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenreDTO> deleteCard(@PathVariable("id") Long genreId) {

        genreService.delete(genreId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GenreDTO>> getAllGenres() {

        return new ResponseEntity<>(genreService.getAll(), HttpStatus.OK);
    }
}
