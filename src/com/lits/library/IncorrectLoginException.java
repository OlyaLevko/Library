package com.lits.library;

import java.util.InputMismatchException;

public class IncorrectLoginException extends InputMismatchException {

    public IncorrectLoginException(String message) {
        super(message);
    }
}
