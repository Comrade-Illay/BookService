package net.illay.libraryProject.bookService.mappers;

import net.illay.libraryProject.bookService.entity.Author;
import net.illay.libraryProject.bookService.model.AuthorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO toDto(Author author);

    Author toEntity(AuthorDTO authorDTO);

    List<AuthorDTO> map(List<Author> author);
}