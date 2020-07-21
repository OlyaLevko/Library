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


    public Record(User user, int bookNumber) {
        this.user = user;
        this.bookNumber = bookNumber;
        this.date = LocalDate.now();

    }

    public Record(User user, int bookNumber, int year, int month, int day) {
        this.user = user;
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
