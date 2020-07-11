package Library;

import java.util.ArrayList;
//група показує базу всіх записів, якщо user бере книгу, ми додаємо новий запис. Тут мають бути
//методи взяти книгу і показати боржників
public class BaseOfRecords {
    ArrayList<Record> records;


    public BaseOfRecords() {
        records = new ArrayList<>();
    }
    public void addRecord(String firstname, String surname, int bookNumber){
        records.add(new Record(firstname, surname, bookNumber));
    }
}
