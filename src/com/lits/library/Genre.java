package com.lits.library;

public enum Genre {
    ROMANCE,
    ADVENTURE,
    HISTORY,
    THRILLER,
    HORROR,
    DETECTIVE,
    COMICS,
    FANTASY,
    PSYCHOLOGY,
    CHILDRENS,
    SCIENCE,
    PHILOSOPHY;

    public static void listOfGenre() {
        for (Genre genre : values()) {
            System.out.println(genre.ordinal() + 1 + ". " + valueOf(genre.toString()));
        }
    }

    public static Genre switchGenre(int a) {
        for (Genre genre : values()) {
            if (a == genre.ordinal() + 1)
                return genre;
        }
        return null;
    }
}
