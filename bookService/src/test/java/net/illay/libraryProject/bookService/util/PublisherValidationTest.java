package net.illay.libraryProject.bookService.util;

import net.illay.libraryProject.bookService.config.TestConfig;
import net.illay.libraryProject.bookService.entity.Publisher;
import net.illay.libraryProject.bookService.service.PublisherService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)
public class PublisherValidationTest {

    @Autowired
    private PublisherValidator publisherValidator;

    @Autowired
    private PublisherService publisherService;

    private static final String publisherName = "Publishing agency";
    private static final Publisher publisher = mock(Publisher.class);

    @BeforeAll
    public static void setup(){
        when(publisher.getPublisherName()).thenReturn(publisherName);
    }

    @Test
    public void validateShouldAcceptPublisherWithName(){
        when(publisherService.getByName(publisherName)).thenReturn(null);
        Errors errors = mock(Errors.class);
        publisherValidator.validate(publisher, errors);
        verify(errors, never()).rejectValue(eq("name"), any(), any());
    }

    @Test
    public void validateShouldRejectPublisherWithExistedName(){
        when(publisherService.getByName(publisherName)).thenReturn(publisher);
        Errors errors = mock(Errors.class);
        publisherValidator.validate(publisher, errors);
        verify(errors, times(1)).rejectValue(eq("name"), any(), any());
    }
}
