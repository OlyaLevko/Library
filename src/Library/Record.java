package Library;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Record {

    User user;
    int bookNumber;
    LocalDate date;


    public Record(String firstName, String surname, int bookNumber) {
        this.user = new User(firstName, surname);
        this.bookNumber = bookNumber;
        this.date = LocalDate.now();

    }

    public Record(String firstName, String surname, int bookNumber, int year, int month, int day) {
        this.user = new User(firstName, surname);
        this.bookNumber = bookNumber;
        this.date = LocalDate.of(year, month, day);

    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return user.getFirstName() + " " + user.getSurName() + " has taken a book with a number " +
                bookNumber +" on " + formatter.format(date);
    }
}
