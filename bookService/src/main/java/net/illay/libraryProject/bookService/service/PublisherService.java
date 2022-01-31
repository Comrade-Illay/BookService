package net.illay.libraryProject.bookService.service;

import net.illay.libraryProject.bookService.entity.Publisher;
import net.illay.libraryProject.bookService.model.PublisherDTO;

import java.util.List;

public interface PublisherService {

    PublisherDTO getById(Long id);
    PublisherDTO update(PublisherDTO publisherDTO);
    void save(PublisherDTO publisherDTO);
    void delete(Long id);
    List<PublisherDTO> getAll();
    Publisher getByName(String name);
}