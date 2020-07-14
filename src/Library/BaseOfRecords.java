package Library;

import java.util.ArrayList;

//група показує базу всіх записів, якщо user бере книгу, ми додаємо новий запис. Тут мають бути
//методи взяти книгу і показати боржників

public class BaseOfRecords {

    ArrayList<Record> records;



    public BaseOfRecords() {

        records = new ArrayList<>();
        records.add(new Record("Robert", "Stark", 1010, 2020, 07, 10));
        records.add(new Record("John", "Snow", 1032, 2020, 07, 14));
        records.add(new Record("Daenerys", "Targaryen", 1015, 2020,06, 30));
        records.add(new Record("Tyrion","Lannister", 1046, 2020,06,21));
        records.add(new Record("The Night", "King", 1047, 2020,03,03));
        records.add(new Record("Samwell", "Tarly", 1001, 2020,07,13));
        records.add(new Record("Sansa", "Stark", 1020, 2020,07,14));
        records.add(new Record("Jaime", "Lannister", 1040, 2020,07,01));

    }


    public Record addRecord(String firstName, String surname, int bookNumber){
        Record r = new Record(firstName, surname, bookNumber);
        records.add(r);
        return r;
    }


}
