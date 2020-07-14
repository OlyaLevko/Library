package Library;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Record {

    User user;
    int bookNumber;
    GregorianCalendar date;


    public Record(String firstName, String surname, int bookNumber) {
        this.user = new User(firstName, surname);
        this.bookNumber = bookNumber;
        this.date = new GregorianCalendar();

    }

    public Record(String firstName, String surname, int bookNumber, int year, int month, int day) {
        this.user = new User(firstName, surname);
        this.bookNumber = bookNumber;
        this.date = new GregorianCalendar(year, month-1, day);

    }

    @Override
    public String toString() {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        return user.getFirstName() + " " + user.getSurName() + " has taken a book with a number " +
                bookNumber +" on " + date.toZonedDateTime().format(DateTimeFormatter.ofPattern("d.MM.uuuu"));
    }
}
