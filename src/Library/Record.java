package Library;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {

    User user;
    int bookNumber;
    String date;


    public Record(String firstName, String surname, int bookNumber) {
        this.user = new User(firstName, surname);
        this.bookNumber = bookNumber;
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        this.date = formatForDateNow.format(new Date());
    }

    @Override
    public String toString() {
        return user.getFirstName() + " " + user.getSurName() + " has taken a book with a number " +
                bookNumber +" on " + date;
    }
}
