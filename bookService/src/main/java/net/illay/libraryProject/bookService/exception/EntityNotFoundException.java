package net.illay.libraryProject.bookService.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(Exception e) {
        super(e);
    }

    public EntityNotFoundException(String message, Exception e) {
        super(message, e);
    }
}
