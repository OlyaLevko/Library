package Library;

import java.util.ArrayList;

//група показує базу всіх записів, якщо user бере книгу, ми додаємо новий запис.

public class BaseOfRecords {

    ArrayList<Record> records;
    BaseOfUsers users;



    public BaseOfRecords() {
        users = new BaseOfUsers();
        records = new ArrayList<>();
        records.add(new Record(users.getUser("KingInTheNorth"), 1010, 2020, 07, 19));
        records.add(new Record(users.getUser("TheGeneratorOfGeniusIdeas"), 1032, 2020, 07, 14));
        records.add(new Record(users.getUser("TheMotherOfDragons"), 1015, 2020,06, 30));
        records.add(new Record(users.getUser("TheGiant"), 1046, 2020,06,21));
        records.add(new Record(users.getUser("TheOwnerOfHumanMinds"), 1047, 2020,03,03));
        records.add(new Record(users.getUser("TheOwnerOfHumanMinds"), 1032, 2020,03,03));
        records.add(new Record(users.getUser("TheBookWorm"), 1001, 2020,07,21));
        records.add(new Record(users.getUser("PrettyLittleGirl"), 1020, 2020,07,14));
        records.add(new Record(users.getUser("TheHandsome"), 1040, 2020,07,21));

    }


    public Record addRecord(String firstName, String surname, int bookNumber){
        Record r = new Record(new User(firstName, surname), bookNumber);
        records.add(r);
        return r;
    }

    public void removeRecord(int bookNumber){
        records.removeIf(record -> record.bookNumber==bookNumber);
    }


}
