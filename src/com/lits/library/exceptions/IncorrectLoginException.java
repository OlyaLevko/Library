package com.lits.library.exceptions;

import java.util.InputMismatchException;

public class IncorrectLoginException extends InputMismatchException {

    public IncorrectLoginException(String message) {
        super(message);
    }
}
