package com.lits.library;

public class Book {

    private String title;
    private String author;
    private Genre genre;
    boolean isAvailable;//при створенні книги по замовчуванні true, коли user бере книгу,
    //цю змінну міняємо на false


    public Book(String title, String author, Genre genre) {

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "The book \"" + title + "\" by " + author + ", " + genre.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.length() > 0 && title.length() < 40)
            this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author.matches("^[\\p{L} .'-]+$"))
            this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {

        this.genre = genre;
    }
}
