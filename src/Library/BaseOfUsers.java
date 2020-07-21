package Library;

import java.util.HashMap;
import java.util.Map;

public class BaseOfUsers {
    Map<String, User> baseOfUsers;
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
}
