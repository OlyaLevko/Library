package com.lits.library;

public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(String message) {
        super(message);
    }
}