package net.illay.libraryProject.bookService.mappers;

import net.illay.libraryProject.bookService.entity.Publisher;
import net.illay.libraryProject.bookService.model.PublisherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    PublisherDTO toDto(Publisher publisher);

    Publisher toEntity(PublisherDTO publisherDTO);

    List<PublisherDTO> map(List<Publisher> publisher);
}

