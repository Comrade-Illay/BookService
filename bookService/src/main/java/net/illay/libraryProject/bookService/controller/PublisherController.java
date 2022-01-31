package net.illay.libraryProject.bookService.controller;

import net.illay.libraryProject.bookService.logging.LogEntryExit;
import net.illay.libraryProject.bookService.model.PublisherDTO;
import net.illay.libraryProject.bookService.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api/bookservice/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublisherDTO> getPublisher(@PathVariable("id") Long publisherId) {

        return new ResponseEntity<>(publisherService.getById(publisherId), HttpStatus.OK);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublisherDTO> savePublisher(@Valid @RequestBody PublisherDTO publisherDTO) {

        publisherService.save(publisherDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublisherDTO> updatePublisher(@Valid @RequestBody PublisherDTO publisherDTO) {

        return new ResponseEntity<>(publisherService.update(publisherDTO), HttpStatus.OK);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublisherDTO> deleteCard(@PathVariable("id") Long publisherId) {

        publisherService.delete(publisherId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PublisherDTO>> getAllPublishers() {

        return new ResponseEntity<>(publisherService.getAll(), HttpStatus.OK);
    }
}
