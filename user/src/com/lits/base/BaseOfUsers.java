package com.lits.base;

import com.lits.servise.UserOption;
import com.lits.user.User;

import java.util.HashMap;
import java.util.Map;

public class BaseOfUsers {
    private Map<String, User> baseOfUsers;
    //key = login;

    public BaseOfUsers() {
        this.baseOfUsers = new HashMap<>();
        baseOfUsers.put("KingInTheNorth", new User("Robert", "Stark"));
        baseOfUsers.put("TheGeneratorOfGeniusIdeas", new User("John", "Snow"));
        baseOfUsers.put("TheMotherOfDragons", new User("Daenerys", "Targaryen"));
        baseOfUsers.put("TheGiant", new User("Tyrion","Lannister"));
        baseOfUsers.put("TheOwnerOfHumanMinds", new User("The Night", "King"));
        baseOfUsers.put("TheBookWorm",new User("Samwell", "Tarly"));
        baseOfUsers.put("PrettyLittleGirl", new User("Sansa", "Stark"));
        baseOfUsers.put("TheHandsome", new User("Jaime", "Lannister"));
        baseOfUsers.put("TheMany-Faced", new User("Arya", "Stark"));
        baseOfUsers.put("TheRealQueen", new User("Cersei","Lannister"));
        baseOfUsers.put("TheThree-EyedRaven", new User("Bran", "Stark"));
        baseOfUsers.put("TheChosenOne", new User("Stanis", "Barateon"));
    }

    public User getUser(String login){
        return baseOfUsers.get(login);
    }

    public Map<String, User> getBaseOfUsers() {
        return baseOfUsers;
    }

    public void setBaseOfUsers(Map<String, User> baseOfUsers) {
        this.baseOfUsers = baseOfUsers;
    }
}
