package net.illay.libraryProject.bookService.service;

import net.illay.libraryProject.bookService.entity.Publisher;
import net.illay.libraryProject.bookService.exception.EntityNotFoundException;
import net.illay.libraryProject.bookService.logging.LogEntryExit;
import net.illay.libraryProject.bookService.mappers.PublisherMapper;
import net.illay.libraryProject.bookService.model.PublisherDTO;
import net.illay.libraryProject.bookService.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService{

    @Autowired
    private PublisherRepository publisherRepository;

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    public PublisherDTO getById(Long id) {
        if (publisherRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Publisher by id: " + id + " not found");
        }
        return PublisherMapper.INSTANCE.toDto(publisherRepository.findById(id).get());
    }

    @LogEntryExit(showArgs = true, showResult = false, unit = ChronoUnit.MILLIS)
    public void save(PublisherDTO publisherDTO) {
        Publisher publisher = PublisherMapper.INSTANCE.toEntity(publisherDTO);
        publisherRepository.save(publisher);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    public PublisherDTO update(PublisherDTO publisherDTO) {
        Publisher publisher = PublisherMapper.INSTANCE.toEntity(publisherDTO);
        return PublisherMapper.INSTANCE.toDto(publisherRepository.save(publisher));
    }

    @LogEntryExit(showArgs = true, showResult = false, unit = ChronoUnit.MILLIS)
    public void delete(Long id) {
        if (publisherRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Publisher by id: " + id + " not found");
        }
        publisherRepository.deleteById(id);
    }

    @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    public List<PublisherDTO> getAll() {
        if (publisherRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Cards not found");
        }
        return PublisherMapper.INSTANCE.map(publisherRepository.findAll());
    }

    public Publisher getByName(String name){
        return publisherRepository.findByPublisherName(name);
    }
}
