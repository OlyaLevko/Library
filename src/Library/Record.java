package Library;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {

    User user;
    int bookNumber;
    String date;


    public Record(String firstname, String surname, int bookNumber) {
        this.user = new User(firstname, surname);
        this.bookNumber = bookNumber;
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        this.date = formatForDateNow.format(new Date());
    }
}
