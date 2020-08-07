package com.lits.library.service;

import com.lits.library.books.Library;

public class UserService {

    Library library;

    public UserService(Library library) {
        this.library = library;
    }

    public void userChoice(int choice) {
        switch (choice) {
            case 1 -> {
                library.showAvailable();
            }
            case 2 -> {
                library.showByGenre();
            }
            case 3 -> {
                library.takeBook();
            }
            case 4 -> {
                library.giveBookBack();
            }
        }
    }
}

