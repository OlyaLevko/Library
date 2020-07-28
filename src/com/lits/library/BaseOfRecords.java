package com.lits.library;


import com.lits.servise.UserOption;

import java.util.ArrayList;

//група показує базу всіх записів, якщо user бере книгу, ми додаємо новий запис.

public class BaseOfRecords {

    private ArrayList<Record> records;
    public UserOption uo;




    public BaseOfRecords() {
        uo = new UserOption();
        uo.downloadBaseOfUsers();
        records = new ArrayList<>();
        uo.setUser(uo.getUserByLogin("KingInTheNorth"));
        records.add(new Record(uo.getUserFirstName(), uo.getUserSurname(), 1010, 2020, 07, 19));
        uo.setUser(uo.getUserByLogin("TheGeneratorOfGeniusIdeas"));
        records.add(new Record(uo.getUserFirstName(),uo.getUserSurname(), 1032, 2020, 07, 14));
        uo.setUser(uo.getUserByLogin("TheMotherOfDragons"));
        records.add(new Record(uo.getUserFirstName(), uo.getUserSurname(), 1015, 2020,06, 30));
        uo.setUser(uo.getUserByLogin("TheGiant"));
        records.add(new Record(uo.getUserFirstName(), uo.getUserSurname(), 1046, 2020,06,21));
        uo.setUser(uo.getUserByLogin("TheOwnerOfHumanMinds"));
        records.add(new Record(uo.getUserFirstName(), uo.getUserSurname(),1047, 2020,03,03));
        uo.setUser(uo.getUserByLogin("TheOwnerOfHumanMinds"));
        records.add(new Record(uo.getUserFirstName(), uo.getUserSurname(), 1032, 2020,03,03));
        uo.setUser(uo.getUserByLogin("TheBookWorm"));
        records.add(new Record(uo.getUserFirstName(), uo.getUserSurname(), 1001, 2020,07,21));
        uo.setUser(uo.getUserByLogin("PrettyLittleGirl"));
        records.add(new Record(uo.getUserFirstName(), uo.getUserSurname(), 1020, 2020,07,14));
        uo.setUser(uo.getUserByLogin("TheHandsome"));
        records.add(new Record(uo.getUserFirstName(), uo.getUserSurname(),   1040, 2020,07,21));

    }


    public Record addRecord(String firstName, String surname, int bookNumber){
        uo.addUser(firstName, surname);
        Record r = new Record(uo.getUserFirstName(),uo.getUserSurname(), bookNumber);
        records.add(r);
        return r;
    }

    public void removeRecord(int bookNumber){
        records.removeIf(record -> record.getBookNumber()==bookNumber);
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }

    public UserOption getUo() {
        return uo;
    }

    public void setUo(UserOption uo) {
        this.uo = uo;
    }
}
