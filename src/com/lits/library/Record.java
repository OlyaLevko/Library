package com.lits.library;



import com.lits.service.UserOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Record {

    private UserOption uo;
    private int bookNumber;
    private LocalDate date;


    public Record(String firstName, String surname, int bookNumber) {
        uo = new UserOption();
        uo.addUser(firstName, surname);
        this.bookNumber = bookNumber;
        this.date = LocalDate.now();
    }

    public Record(String firstName, String surname, int bookNumber, int year, int month, int day) {
        uo = new UserOption();
        uo.addUser(firstName, surname);
        this.bookNumber = bookNumber;
        this.date = LocalDate.of(year, month, day);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return uo.getUserFirstName() + " " + uo.getUserSurname() + " has taken a book with a number " +
                bookNumber + " on " + formatter.format(date);
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}