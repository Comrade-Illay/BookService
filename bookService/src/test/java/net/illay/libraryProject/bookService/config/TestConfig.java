package net.illay.libraryProject.bookService.config;

import net.illay.libraryProject.bookService.service.PublisherService;
import net.illay.libraryProject.bookService.util.PublisherValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class TestConfig {

    @Bean
    public PublisherValidator publisherValidator(){
        return new PublisherValidator();
    }

    @Bean
    public PublisherService publisherService(){
        return mock(PublisherService.class);
    }
}
