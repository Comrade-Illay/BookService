package net.illay.libraryProject.bookService.mappers;

import net.illay.libraryProject.bookService.entity.Genre;
import net.illay.libraryProject.bookService.model.GenreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    GenreDTO toDto(Genre genre);

    Genre toEntity(GenreDTO genreDTO);

    List<GenreDTO> map(List<Genre> genre);
}
