package net.illay.libraryProject.bookService.repository;

import net.illay.libraryProject.bookService.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}

