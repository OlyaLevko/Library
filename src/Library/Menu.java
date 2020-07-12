package Library;

public class Menu {
    //  start User (Start Program)
    public void startApp() {
        greetUser();
        System.out.println("Hello user, please select items 1-5: ");
    }

    // start Admin
    public void startAdmin() {
        greetAdmin();
        System.out.println("Hello admin, please select items 1-6: ");
    }

    //  menu user info
    private void greetUser() {
        System.out.println("1. admin");
        System.out.println("2. look at the available books");
        System.out.println("3. look at all genres");
        System.out.println("4. take a book / books");
        System.out.println("5. delete book");
        System.out.println("6. exit the program");
        UserService us = new UserService();
        us.inputUser();
    }

    //  menu admin info
    private void greetAdmin() {
        System.out.println("1. add book / books");
        System.out.println("2. delete book");
        System.out.println("3. look at the available books");
        System.out.println("4. books that users have");
        System.out.println("5. look at debtors");
        System.out.println("6. return to the main menu");
        AdminService ad = new AdminService();
        ad.inputAdmin();
    }
}
