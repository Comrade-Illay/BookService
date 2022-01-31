package net.illay.libraryProject.bookService.repository;

import net.illay.libraryProject.bookService.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Publisher findByPublisherName(String name);

}
