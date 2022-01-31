package net.illay.libraryProject.bookService.mappers;

import net.illay.libraryProject.bookService.entity.Book;
import net.illay.libraryProject.bookService.model.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDto(Book book);

    Book toEntity(BookDTO bookDTO);

    List<BookDTO> map(List<Book> book);
}