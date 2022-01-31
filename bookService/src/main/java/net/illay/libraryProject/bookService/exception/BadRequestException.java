package net.illay.libraryProject.bookService.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(Exception e) {
        super(e);
    }

    public BadRequestException(String message, Exception e) {
        super(message, e);
    }
}
