package Library;

public class User {

    private  String firstName;
    private String surName;



    public User(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.matches("^[A-Z][a-z]{1,20}")) {
            this.firstName = firstName;
        }
        else System.out.println("You are trying to enter an incorrect First name.");
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        if(surName.matches("^[A-Z][a-z]{1,20}")) {
            this.surName = surName;
        }
        else System.out.println("You are trying to enter an incorrect Surname.");
    }

}
