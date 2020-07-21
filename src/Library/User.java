package Library;

public class User {

    private  String firstName;
    private String surName;

    public User() {
    }

    public User(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.matches("^[A-Z][\\p{L}'-]+$")) {
            this.firstName = firstName;
        }
        else System.out.println("You are trying to enter an incorrect First name.");
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        if(surName.matches("^[A-Z][\\p{L}'-]+$")) {
            this.surName = surName;
        }
        else System.out.println("You are trying to enter an incorrect Surname.");
    }

}
