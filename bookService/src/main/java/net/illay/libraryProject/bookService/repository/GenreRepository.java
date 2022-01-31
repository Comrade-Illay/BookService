package net.illay.libraryProject.bookService.repository;

import net.illay.libraryProject.bookService.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
