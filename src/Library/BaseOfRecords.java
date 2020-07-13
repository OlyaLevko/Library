package Library;

import java.util.ArrayList;
//група показує базу всіх записів, якщо user бере книгу, ми додаємо новий запис. Тут мають бути
//методи взяти книгу і показати боржників
public class BaseOfRecords {

    ArrayList<Record> records;


    public BaseOfRecords() {
        records = new ArrayList<>();
    }


    public Record addRecord(String firstName, String surname, int bookNumber){
        Record r = new Record(firstName, surname, bookNumber);
        records.add(r);
        return r;
    }

    // тут має бути метод takeBook() який відповідає опції взяти книгу (Валентин)

    //тут має бути метод showDebtors() який показує боржників (Валентин)
}
