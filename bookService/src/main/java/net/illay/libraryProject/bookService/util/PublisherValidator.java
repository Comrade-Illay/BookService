package net.illay.libraryProject.bookService.util;

/*This class was created only for testing purposes*/

import net.illay.libraryProject.bookService.entity.Publisher;
import net.illay.libraryProject.bookService.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PublisherValidator implements Validator {

    @Autowired
    private PublisherService publisherService;

    @Override
    public boolean supports(Class<?> clazz){
        return Publisher.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        Publisher publisher = (Publisher) target;
        if(publisherService.getByName(publisher.getPublisherName()) != null) {
            errors.rejectValue("name", "", "This publisher name already in use");
        }
    }
}
