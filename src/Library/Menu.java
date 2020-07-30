package Library;

public class Menu {

    //  start User (Start Program)
    public void startApp() {
        greetUser();
    }

    // start Admin
    public void startAdmin() {
        greetAdmin();
    }

    //  menu user info
    private void greetUser() {
        System.out.println("1. admin");
        System.out.println("2. available books");
        System.out.println("3. look genres");
        System.out.println("4. take a book/books");
        System.out.println("5. exit");
        System.out.println("Hello user, please select items 1-5: ");
        new UserService().inputUser();
    }

    //  menu admin info
    private void greetAdmin() {
        System.out.println("1. add book/books");
        System.out.println("2. remove book");
        System.out.println("3. available books");
        System.out.println("4. using book");
        System.out.println("5. debtors");
        System.out.println("6. return to the main menu");
        System.out.println("Hello admin, please select items 1-6: ");
        new AdminService().inputAdmin();
    }
}