package org.acme.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
        super("Book does not exsit.");
    }
}
